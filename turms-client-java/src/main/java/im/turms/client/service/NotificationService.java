package im.turms.client.service;

import im.turms.client.TurmsClient;
import im.turms.common.model.dto.request.TurmsRequest;

import java.util.function.BiFunction;

public class NotificationService {
    private final TurmsClient turmsClient;
    public BiFunction<TurmsRequest, Long, Void> onNotification;

    public NotificationService(TurmsClient turmsClient) {
        this.turmsClient = turmsClient;
        this.turmsClient.getDriver()
                .getOnNotificationListeners()
                .add(notification -> {
                    if (onNotification != null && notification.hasRelayedRequest()) {
                        Long requesterId = notification.hasRequesterId() ?
                                notification.getRequesterId().getValue() : null;
                        onNotification.apply(notification.getRelayedRequest(), requesterId);
                    }
                    return null;
                });
    }
}
