package im.turms.plugin.impl;

import im.turms.common.TurmsStatusCode;
import im.turms.common.constant.ContentType;
import im.turms.common.exception.TurmsBusinessException;
import im.turms.turms.common.TurmsLogger;
import im.turms.turms.plugin.StorageServiceProvider;
import im.turms.turms.plugin.TurmsPlugin;
import im.turms.turms.property.TurmsProperties;
import org.pf4j.Extension;
import org.pf4j.PluginWrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.util.MimeTypeUtils;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.http.async.SdkAsyncHttpClient;
import software.amazon.awssdk.http.nio.netty.NettyNioAsyncHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.S3Configuration;
import software.amazon.awssdk.services.s3.model.*;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TurmsMinioPlugin extends TurmsPlugin {
    public TurmsMinioPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Extension
    public static class MinioStorageServiceProvider extends StorageServiceProvider {
        private URI endpoint;
        private S3AsyncClient client;
        private S3Presigner presigner;
        private TurmsProperties turmsProperties;

        @Override
        public void setContext(ApplicationContext context) throws Exception {
            super.setContext(context);
            setUp();
        }

        @Override
        public Mono<Void> deleteResource(@NotNull Long requesterId, @NotNull ContentType contentType, String keyStr, @Nullable Long keyNum) {
            String key;
            switch (contentType) {
                case PROFILE:
                    key = requesterId.toString();
                    break;
                case GROUP_PROFILE:
                    if (keyNum != null) {
                        key = keyNum.toString();
                    } else {
                        throw TurmsBusinessException.get(TurmsStatusCode.ILLEGAL_ARGUMENTS);
                    }
                    break;
                case ATTACHMENT:
                    throw TurmsBusinessException.get(TurmsStatusCode.ILLEGAL_ARGUMENTS);
                default:
                    throw new IllegalStateException("Unexpected value: " + contentType);
            }
            DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                    .bucket(getBucketName(contentType))
                    .key(key)
                    .build();
            return Mono.fromFuture(client.deleteObject(deleteObjectRequest)).then();
        }

        @Override
        public Mono<String> queryPresignedGetUrl(@NotNull Long requesterId, @NotNull ContentType contentType, String keyStr, @Nullable Long keyNum) {
            switch (contentType) {
                case PROFILE:
                case GROUP_PROFILE:
                    throw TurmsBusinessException.get(TurmsStatusCode.REDUNDANT_REQUEST);
                case ATTACHMENT:
                    if (keyNum != null) {
                        String key;
                        if (keyStr != null) {
                            key = String.format("%d/%s", keyNum, keyStr);
                        } else {
                            key = keyNum.toString();
                        }
                        String url = presignedUrlForGet(getBucketName(contentType), key);
                        return Mono.just(url);
                    } else {
                        throw TurmsBusinessException.get(TurmsStatusCode.ILLEGAL_ARGUMENTS);
                    }
                default:
                    throw new IllegalStateException("Unexpected value: " + contentType);
            }
        }

        @Override
        public Mono<String> queryPresignedPutUrl(@NotNull Long requesterId, @NotNull ContentType contentType, @Nullable String keyStr, @Nullable Long keyNum, long contentLength) {
            String type;
            String objectKey;
            switch (contentType) {
                case PROFILE:
                    type = turmsProperties.getStorage().getProfileContentType();
                    objectKey = requesterId.toString();
                    break;
                case GROUP_PROFILE:
                    type = turmsProperties.getStorage().getGroupProfileContentType();
                    if (keyNum != null) {
                        objectKey = keyNum.toString();
                    } else {
                        throw TurmsBusinessException.get(TurmsStatusCode.ILLEGAL_ARGUMENTS);
                    }
                    break;
                case ATTACHMENT:
                    type = turmsProperties.getStorage().getAttachmentContentType();
                    if (keyNum != null) {
                        if (keyStr != null) {
                            objectKey = String.format("%d/%s", keyNum, keyStr);
                        } else {
                            objectKey = keyNum.toString();
                        }
                    } else {
                        throw TurmsBusinessException.get(TurmsStatusCode.ILLEGAL_ARGUMENTS);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + contentType);
            }
            String url = presignedPutUrl(getBucketName(contentType), objectKey, type);
            return Mono.just(url);
        }

        private void setUp() throws InterruptedException, ExecutionException, TimeoutException {
            turmsProperties = getContext().getBean(TurmsProperties.class);
            Environment env = getContext().getEnvironment();
            String endpointStr = env.getProperty("turms.storage.minio.endpoint", "http://localhost:9000");
            String accessKey = env.getProperty("turms.storage.minio.accessKey", "minioadmin");
            String secretKey = env.getProperty("turms.storage.minio.secretKey", "minioadmin");
            String regionStr = env.getProperty("turms.storage.minio.region", Region.AWS_GLOBAL.toString());
            Region region = Region.of(regionStr);
            endpoint = URI.create(endpointStr);

            SdkAsyncHttpClient httpClient = NettyNioAsyncHttpClient.builder()
                    .writeTimeout(Duration.ZERO)
                    .maxConcurrency(64)
                    .build();
            S3Configuration configuration = S3Configuration.builder()
                    .checksumValidationEnabled(false)
                    .chunkedEncodingEnabled(true)
                    .build();
            AwsCredentialsProvider credentialsProvider = () -> AwsBasicCredentials.create(accessKey, secretKey);
            client = S3AsyncClient.builder()
                    .httpClient(httpClient)
                    .endpointOverride(endpoint)
                    .region(region)
                    .credentialsProvider(credentialsProvider)
                    .serviceConfiguration(configuration)
                    .build();
            presigner = S3Presigner.builder()
                    .endpointOverride(endpoint)
                    .credentialsProvider(credentialsProvider)
                    .region(region)
                    .build();
            initMinio();
        }

        private void initMinio() throws InterruptedException, ExecutionException, TimeoutException {
            for (ContentType type : ContentType.values()) {
                if (type != ContentType.UNRECOGNIZED) {
                    boolean exists = bucketExists(type);
                    String bucket = getBucketName(type);
                    if (!exists) {
                        TurmsLogger.log(String.format("Bucket: %s is being created", bucket));
                        createBucket(type);
                        putBucketPolicy(type);
                        putBucketLifecycleConfig(type);
                    } else {
                        TurmsLogger.log(String.format("Bucket: %s exists", bucket));
                    }
                }
            }
        }

        private void createBucket(ContentType contentType) throws InterruptedException, ExecutionException, TimeoutException {
            CreateBucketRequest request = CreateBucketRequest.builder()
                    .bucket(getBucketName(contentType))
                    .build();
            client.createBucket(request).get(30, TimeUnit.SECONDS);
        }

        private void putBucketPolicy(ContentType contentType) throws InterruptedException, ExecutionException, TimeoutException {
            if (contentType == ContentType.PROFILE || contentType == ContentType.GROUP_PROFILE) {
                String bucket = getBucketName(contentType);
                String policy = "{\n" +
                        "  \"Version\": \"2012-10-17\",\n" +
                        "  \"Statement\": [\n" +
                        "    {\n" +
                        "      \"Action\": [\n" +
                        "        \"s3:GetObject\"\n" +
                        "      ],\n" +
                        "      \"Effect\": \"Allow\",\n" +
                        "      \"Resource\": \"arn:aws:s3:::" + bucket + "/*\",\n" +
                        "      \"Principal\": \"*\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";
                PutBucketPolicyRequest policyRequest = PutBucketPolicyRequest.builder()
                        .bucket(bucket)
                        .policy(policy)
                        .build();
                client.putBucketPolicy(policyRequest).get(5, TimeUnit.SECONDS);
            }
        }

        private void putBucketLifecycleConfig(ContentType contentType) throws InterruptedException, ExecutionException, TimeoutException {
            if (contentType != ContentType.UNRECOGNIZED) {
                int days;
                switch (contentType) {
                    case PROFILE:
                        days = turmsProperties.getStorage().getProfileExpiration();
                        break;
                    case GROUP_PROFILE:
                        days = turmsProperties.getStorage().getGroupProfileExpiration();
                        break;
                    case ATTACHMENT:
                        days = turmsProperties.getStorage().getAttachmentExpiration();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + contentType);
                }
                if (days > 0) {
                    LifecycleExpiration expiration = LifecycleExpiration.builder().days(days).build();
                    LifecycleRule rule = LifecycleRule.builder()
                            .expiration(expiration)
                            .status(ExpirationStatus.ENABLED)
                            .build();
                    BucketLifecycleConfiguration configuration = BucketLifecycleConfiguration.builder()
                            .rules(rule)
                            .build();
                    PutBucketLifecycleConfigurationRequest request = PutBucketLifecycleConfigurationRequest.builder()
                            .bucket(getBucketName(contentType))
                            .lifecycleConfiguration(configuration)
                            .build();
                    client.putBucketLifecycleConfiguration(request).get(30, TimeUnit.SECONDS);
                }
            }
        }

        private boolean bucketExists(ContentType contentType) throws InterruptedException, ExecutionException, TimeoutException {
            try {
                HeadBucketRequest request = HeadBucketRequest.builder()
                        .bucket(getBucketName(contentType))
                        .build();
                HeadBucketResponse response = client.headBucket(request).get(30, TimeUnit.SECONDS);
                return 200 == response.sdkHttpResponse().statusCode();
            } catch (Exception e) {
                if (e.getCause() instanceof NoSuchBucketException) {
                    return false;
                } else {
                    throw e;
                }
            }
        }

        private String presignedUrlForGet(@NotNull String bucket, @NotNull String key) {
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket(bucket)
                    .key(key)
                    .build();
            GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                    .getObjectRequest(getObjectRequest)
                    .signatureDuration(turmsProperties.getStorage().getSignatureDurationForGet())
                    .build();
            PresignedGetObjectRequest request = presigner.presignGetObject(presignRequest);
            return request.url().toString();
        }

        private String presignedPutUrl(@NotNull String bucket, @NotNull String key, @Nullable String contentType) {
            PutObjectRequest.Builder builder = PutObjectRequest.builder()
                    .bucket(bucket)
                    .key(key);
            if (contentType != null && !contentType.equals(MimeTypeUtils.ALL_VALUE)) {
                builder.contentType(contentType);
            }
            PutObjectRequest putObjectRequest = builder.build();
            PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
                    .putObjectRequest(putObjectRequest)
                    .signatureDuration(turmsProperties.getStorage().getSignatureDurationForPut())
                    .build();
            PresignedPutObjectRequest request = presigner.presignPutObject(presignRequest);
            return request.url().toString();
        }

        private String getBucketName(ContentType contentType) {
            return contentType.name().toLowerCase().replace("_", "-");
        }
    }
}
