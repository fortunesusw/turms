// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: constant/request_status.proto

package im.turms.turms.constant;

public final class RequestStatusOuterClass {
  private RequestStatusOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\035constant/request_status.proto\022\016im.turm" +
      "s.proto*~\n\rRequestStatus\022\013\n\007PENDING\020\000\022\014\n" +
      "\010ACCEPTED\020\001\022\034\n\030ACCEPTED_WITHOUT_CONFIRM\020" +
      "\002\022\014\n\010DECLINED\020\003\022\013\n\007IGNORED\020\004\022\013\n\007EXPIRED\020" +
      "\005\022\014\n\010CANCELED\020\006B\033\n\027im.turms.turms.consta" +
      "ntP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
