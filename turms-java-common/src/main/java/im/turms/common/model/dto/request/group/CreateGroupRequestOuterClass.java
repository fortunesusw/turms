// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: request/group/create_group_request.proto

package im.turms.common.model.dto.request.group;

public final class CreateGroupRequestOuterClass {
  private CreateGroupRequestOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_im_turms_proto_CreateGroupRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_im_turms_proto_CreateGroupRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n(request/group/create_group_request.pro" +
      "to\022\016im.turms.proto\032\036google/protobuf/wrap" +
      "pers.proto\"\237\002\n\022CreateGroupRequest\022\014\n\004nam" +
      "e\030\001 \001(\t\022+\n\005intro\030\002 \001(\0132\034.google.protobuf" +
      ".StringValue\0222\n\014announcement\030\003 \001(\0132\034.goo" +
      "gle.protobuf.StringValue\0222\n\rminimum_scor" +
      "e\030\004 \001(\0132\033.google.protobuf.Int32Value\0222\n\r" +
      "group_type_id\030\005 \001(\0132\033.google.protobuf.In" +
      "t64Value\0222\n\rmute_end_date\030\006 \001(\0132\033.google" +
      ".protobuf.Int64ValueB.\n\'im.turms.common." +
      "model.dto.request.groupP\001\272\002\000b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
        });
    internal_static_im_turms_proto_CreateGroupRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_im_turms_proto_CreateGroupRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_im_turms_proto_CreateGroupRequest_descriptor,
        new java.lang.String[] { "Name", "Intro", "Announcement", "MinimumScore", "GroupTypeId", "MuteEndDate", });
    com.google.protobuf.WrappersProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
