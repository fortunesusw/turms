package im.turms.client.driver;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Int64Value;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import im.turms.client.common.Function4;
import im.turms.client.common.StringUtil;
import im.turms.client.common.TurmsLogger;
import im.turms.client.util.ProtoUtil;
import im.turms.common.TurmsCloseStatus;
import im.turms.common.TurmsStatusCode;
import im.turms.common.constant.DeviceType;
import im.turms.common.constant.UserStatus;
import im.turms.common.exception.TurmsBusinessException;
import im.turms.common.model.bo.user.UserLocation;
import im.turms.common.model.dto.notification.TurmsNotification;
import im.turms.common.model.dto.request.TurmsRequest;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.net.http.WebSocketHandshakeException;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.logging.Level;

import static java.util.AbstractMap.SimpleEntry;

public class TurmsDriver {
    private static final Integer HEARTBEAT_INTERVAL = 20 * 1000;
    public static final String REQUEST_ID_FIELD = "rid";
    public static final String USER_ID_FIELD = "uid";
    public static final String PASSWORD_FIELD = "pwd";
    public static final String DEVICE_TYPE_FIELD = "dt";
    public static final String USER_ONLINE_STATUS_FIELD = "us";
    public static final String USER_LOCATION_FIELD = "loc";
    public static final String USER_DEVICE_DETAILS = "dd";
    private static final String LOCATION_SPLIT = ":";

    private Integer heartbeatInterval;

    private WebSocket websocket;
    private boolean isSessionEstablished;
    private final ScheduledExecutorService heartbeatTimer = Executors.newSingleThreadScheduledExecutor();
    private ScheduledFuture<?> heartbeatFuture;
    private final HashMap<Long, SimpleEntry<TurmsRequest, CompletableFuture<TurmsNotification>>> requestMap = new HashMap<>();

    private List<Function<TurmsNotification, Void>> onNotificationListeners = new LinkedList<>();
    private Function4<Boolean, TurmsCloseStatus, String, Throwable, Void> onClose;

    private String websocketUrl = "ws://localhost:9510";
    private int connectionTimeout = 10 * 1000;
    private int minRequestsInterval = 0;
    private long lastRequestDate = 0;
    private Long userId;
    private String password;
    private UserLocation userLocation;
    private UserStatus userOnlineStatus;
    private DeviceType deviceType;

    private String address;
    private String sessionId;

    public List<Function<TurmsNotification, Void>> getOnNotificationListeners() {
        return onNotificationListeners;
    }

    public String getAddress() {
        return address;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setOnClose(Function4<Boolean, TurmsCloseStatus, String, Throwable, Void> onClose) {
        this.onClose = onClose;
    }

    public TurmsDriver(@Nullable String websocketUrl,
                       @Nullable Integer connectionTimeout,
                       @Nullable Integer minRequestsInterval) {
        if (websocketUrl != null) {
            this.websocketUrl = websocketUrl;
        }
        if (connectionTimeout != null) {
            this.connectionTimeout = connectionTimeout;
        }
        if (minRequestsInterval != null) {
            this.minRequestsInterval = minRequestsInterval;
        }
        this.heartbeatInterval = HEARTBEAT_INTERVAL;
    }

    public CompletableFuture<Void> sendHeartbeat() {
        if (this.connected()) {
            lastRequestDate = System.currentTimeMillis();
            return websocket.sendBinary(ByteBuffer.allocate(0), true)
                    .thenApply(webSocket -> null);
        } else {
            return CompletableFuture.failedFuture(TurmsBusinessException.get(TurmsStatusCode.CLIENT_SESSION_HAS_BEEN_CLOSED));
        }
    }

    public boolean connected() {
        return websocket != null && !websocket.isInputClosed() && !websocket.isOutputClosed();
    }

    public CompletableFuture<Void> disconnect() {
        if (connected()) {
            return this.websocket
                    .sendClose(WebSocket.NORMAL_CLOSURE, "")
                    .thenApply(webSocket -> null);
        } else {
            return CompletableFuture.failedFuture(TurmsBusinessException.get(TurmsStatusCode.CLIENT_SESSION_HAS_BEEN_CLOSED));
        }
    }

    public CompletableFuture<Void> connect(
            long userId,
            @NotNull String password,
            @Nullable Integer connectionTimeout,
            @Nullable UserLocation userLocation,
            @Nullable UserStatus userOnlineStatus,
            @Nullable DeviceType deviceType) {
        if (connectionTimeout == null) {
            connectionTimeout = this.connectionTimeout;
        }
        Integer finalConnectionTimeout = connectionTimeout;
        if (connected()) {
            return CompletableFuture.failedFuture(TurmsBusinessException.get(TurmsStatusCode.CLIENT_SESSION_ALREADY_ESTABLISHED));
        } else {
            this.userId = userId;
            this.password = password;
            this.userLocation = userLocation;
            this.userOnlineStatus = userOnlineStatus;
            this.deviceType = deviceType;
            long connectionRequestId = (long) Math.ceil(Math.random() * Long.MAX_VALUE);
            WebSocket.Builder builder = HttpClient.newHttpClient()
                    .newWebSocketBuilder();
            builder.header(REQUEST_ID_FIELD, String.valueOf(connectionRequestId));
            builder.header(USER_ID_FIELD, String.valueOf(userId));
            builder.header(PASSWORD_FIELD, password);
            if (userLocation != null) {
                String location = String.format("%f%s%f", userLocation.getLongitude(), LOCATION_SPLIT, userLocation.getLatitude());
                builder.header(USER_LOCATION_FIELD, location);
            }
            if (userOnlineStatus != null) {
                builder.header(USER_ONLINE_STATUS_FIELD, userOnlineStatus.toString());
            }
            if (deviceType != null) {
                builder.header(DEVICE_TYPE_FIELD, deviceType.name());
            }
            return builder
                    .connectTimeout(Duration.ofSeconds(finalConnectionTimeout))
                    .buildAsync(URI.create(websocketUrl), new WebSocket.Listener() {

                        @Override
                        public void onOpen(WebSocket webSocket) {
                            webSocket.request(1);
                            onWebsocketOpen();
                        }

                        @Override
                        public CompletionStage<?> onBinary(WebSocket webSocket, ByteBuffer data, boolean last) {
                            webSocket.request(1);
                            TurmsNotification notification;
                            try {
                                notification = TurmsNotification.parseFrom(data);
                            } catch (InvalidProtocolBufferException e) {
                                TurmsLogger.logger.log(Level.SEVERE, "", e);
                                return CompletableFuture.failedStage(e);
                            }
                            if (notification != null) {
                                boolean isSessionInfo = notification.hasData() && notification.getData().hasSession();
                                if (isSessionInfo) {
                                    address = notification.getData().getSession().getAddress();
                                    sessionId = notification.getData().getSession().getSessionId();
                                } else if (notification.hasRequestId()) {
                                    long requestId = notification.getRequestId().getValue();
                                    SimpleEntry<TurmsRequest, CompletableFuture<TurmsNotification>> pair = requestMap.get(requestId);
                                    if (pair != null) {
                                        CompletableFuture<TurmsNotification> future = pair.getValue();
                                        if (notification.hasCode()) {
                                            int code = notification.getCode().getValue();
                                            if (TurmsStatusCode.isSuccess(code)) {
                                                future.complete(notification);
                                            } else {
                                                TurmsBusinessException exception;
                                                if (code == TurmsStatusCode.FAILED.getBusinessCode()) {
                                                    exception = TurmsBusinessException.get(code, notification.getReason().getValue());
                                                } else {
                                                    exception = TurmsBusinessException.get(code);
                                                }
                                                if (exception != null) {
                                                    future.completeExceptionally(exception);
                                                } else {
                                                    TurmsLogger.logger.log(Level.WARNING, "Unknown status code");
                                                }
                                            }
                                        } else {
                                            future.complete(notification);
                                        }
                                    }
                                }
                                for (Function<TurmsNotification, Void> listener : onNotificationListeners) {
                                    try {
                                        listener.apply(notification);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            return CompletableFuture.completedStage(notification);
                        }

                        @Override
                        public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
                            webSocket.request(1);
                            onWebsocketClose(statusCode, reason);
                            return null;
                        }

                        @Override
                        public void onError(WebSocket webSocket, Throwable error) {
                            onWebsocketError(error);
                        }
                    })
                    .whenComplete((webSocket, throwable) -> {
                        if (throwable != null) {
                            Throwable cause = throwable.getCause();
                            // Note that the WebSocketHandshakeException cannot be caught by onError
                            if (cause instanceof WebSocketHandshakeException) {
                                WebSocketHandshakeException handshakeException = (WebSocketHandshakeException) cause;
                                int statusCode = handshakeException.getResponse().statusCode();
                                if (statusCode == 307) {
                                    String address = handshakeException.getResponse()
                                            .headers().firstValue("reason").get();
                                    reconnect(address);
                                }
                            }
                        } else if (webSocket != null) {
                            this.websocket = webSocket;
                        }
                    })
                    .thenApply(webSocket -> null);
        }
    }

    public CompletableFuture<TurmsNotification> send(Message.Builder builder, Map<String, ?> fields) {
        if (fields != null) {
            ProtoUtil.fillFields(builder, fields);
        }
        Descriptors.Descriptor descriptor = builder.getDescriptorForType();
        String fieldName = StringUtil.camelToSnakeCase(descriptor.getName());
        TurmsRequest.Builder requestBuilder = TurmsRequest.newBuilder();
        Descriptors.Descriptor requestDescriptor = requestBuilder.getDescriptorForType();
        Descriptors.FieldDescriptor fieldDescriptor = requestDescriptor.findFieldByName(fieldName);
        requestBuilder.setField(fieldDescriptor, builder.build());
        return send(requestBuilder);
    }

    public CompletableFuture<TurmsNotification> send(TurmsRequest.Builder requestBuilder) {
        if (this.connected()) {
            Date now = new Date();
            if (minRequestsInterval == 0 || now.getTime() - lastRequestDate > minRequestsInterval) {
                lastRequestDate = now.getTime();
                long requestId = generateRandomId();
                requestBuilder.setRequestId(Int64Value.newBuilder().setValue(requestId).build());
                TurmsRequest request = requestBuilder.build();
                ByteBuffer data = ByteBuffer.wrap(request.toByteArray());
                CompletableFuture<TurmsNotification> future = new CompletableFuture<>();
                requestMap.put(requestId, new SimpleEntry<>(request, future));
                websocket.sendBinary(data, true).whenComplete((webSocket, throwable) -> {
                    if (throwable != null) {
                        future.completeExceptionally(throwable);
                    }
                });
                return future;
            } else {
                return CompletableFuture.failedFuture(TurmsBusinessException.get(TurmsStatusCode.CLIENT_REQUESTS_TOO_FREQUENT));
            }
        } else {
            return CompletableFuture.failedFuture(TurmsBusinessException.get(TurmsStatusCode.CLIENT_SESSION_HAS_BEEN_CLOSED));
        }
    }

    private long generateRandomId() {
        long id;
        do {
            id = (long) Math.floor(Math.random() * Long.MAX_VALUE);
        } while (requestMap.containsKey(id));
        return id;
    }

    private void onWebsocketOpen() {
        isSessionEstablished = true;
        heartbeatFuture = this.heartbeatTimer.scheduleAtFixedRate(
                this::checkAndSendHeartbeatTask,
                heartbeatInterval,
                heartbeatInterval,
                TimeUnit.SECONDS);
    }

    private void checkAndSendHeartbeatTask() {
        long difference = System.currentTimeMillis() - lastRequestDate;
        if (difference > minRequestsInterval) {
            this.sendHeartbeat();
        }
    }

    private void onWebsocketClose(int code, String reason) {
        boolean wasLogged = isSessionEstablished;
        isSessionEstablished = false;
        cancelHeartbeatFuture();
        TurmsCloseStatus status = TurmsCloseStatus.get(code);
        if (status == TurmsCloseStatus.REDIRECT) {
            reconnect(reason);
        } else if (onClose != null) {
            if (status == TurmsCloseStatus.WEBSOCKET_ERROR) {
                reason = String.valueOf(code);
            }
            onClose.apply(wasLogged, status, reason, null);
        }
    }

    private void onWebsocketError(Throwable error) {
        boolean wasLogged = isSessionEstablished;
        isSessionEstablished = false;
        cancelHeartbeatFuture();
        onClose.apply(wasLogged, null, null, error);
    }

    private void reconnect(String address) {
        boolean isSecure = websocketUrl.startsWith("wss://");
        websocketUrl = (isSecure ? "wss://" : "ws://") + address;
        this.connect(userId, password, connectionTimeout, userLocation, userOnlineStatus, deviceType);
    }

    private void cancelHeartbeatFuture() {
        if (!heartbeatFuture.isCancelled() && !heartbeatFuture.isDone()) {
            heartbeatFuture.cancel(true);
        }
    }
}
