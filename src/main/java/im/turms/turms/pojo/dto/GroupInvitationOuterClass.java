// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dto/group/group_invitation.proto

package im.turms.turms.pojo.dto;

public final class GroupInvitationOuterClass {
  private GroupInvitationOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_im_turms_proto_GroupInvitation_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_im_turms_proto_GroupInvitation_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n dto/group/group_invitation.proto\022\016im.t" +
      "urms.proto\032\036google/protobuf/wrappers.pro" +
      "to\032\035constant/request_status.proto\"\223\003\n\017Gr" +
              "oupInvitation\022'\n\002id\030\001 \001(\0132\033.google.proto" +
      "buf.Int64Value\0222\n\rcreation_date\030\002 \001(\0132\033." +
      "google.protobuf.Int64Value\022-\n\007content\030\003 " +
      "\001(\0132\034.google.protobuf.StringValue\022-\n\006sta" +
      "tus\030\004 \001(\0162\035.im.turms.proto.RequestStatus" +
      "\0224\n\017expiration_date\030\005 \001(\0132\033.google.proto" +
      "buf.Int64Value\022-\n\010group_id\030\006 \001(\0132\033.googl" +
      "e.protobuf.Int64Value\022/\n\ninviter_id\030\007 \001(" +
      "\0132\033.google.protobuf.Int64Value\022/\n\ninvite" +
      "e_id\030\010 \001(\0132\033.google.protobuf.Int64ValueB" +
      "\033\n\027im.turms.turms.pojo.dtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
          im.turms.turms.constant.RequestStatusOuterClass.getDescriptor(),
        });
    internal_static_im_turms_proto_GroupInvitation_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_im_turms_proto_GroupInvitation_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_im_turms_proto_GroupInvitation_descriptor,
        new java.lang.String[] { "Id", "CreationDate", "Content", "Status", "ExpirationDate", "GroupId", "InviterId", "InviteeId", });
    com.google.protobuf.WrappersProto.getDescriptor();
    im.turms.turms.constant.RequestStatusOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
