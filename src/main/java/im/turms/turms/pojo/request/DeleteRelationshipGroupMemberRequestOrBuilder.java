// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: request/user/relationship/delete_relationship_group_member_request.proto

package im.turms.turms.pojo.request;

public interface DeleteRelationshipGroupMemberRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:im.turms.proto.DeleteRelationshipGroupMemberRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 user_id = 1;</code>
   * @return The userId.
   */
  long getUserId();

  /**
   * <code>int32 group_index = 2;</code>
   * @return The groupIndex.
   */
  int getGroupIndex();

  /**
   * <code>.google.protobuf.Int32Value target_group_index = 3;</code>
   * @return Whether the targetGroupIndex field is set.
   */
  boolean hasTargetGroupIndex();
  /**
   * <code>.google.protobuf.Int32Value target_group_index = 3;</code>
   * @return The targetGroupIndex.
   */
  com.google.protobuf.Int32Value getTargetGroupIndex();
  /**
   * <code>.google.protobuf.Int32Value target_group_index = 3;</code>
   */
  com.google.protobuf.Int32ValueOrBuilder getTargetGroupIndexOrBuilder();
}
