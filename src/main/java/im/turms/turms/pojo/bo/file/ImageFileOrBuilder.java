// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: model/file/image_file.proto

package im.turms.turms.pojo.bo.file;

public interface ImageFileOrBuilder extends
    // @@protoc_insertion_point(interface_extends:im.turms.proto.ImageFile)
    com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.im.turms.proto.ImageFile.Description description = 1;</code>
     *
     * @return Whether the description field is set.
     */
    boolean hasDescription();

    /**
     * <code>.im.turms.proto.ImageFile.Description description = 1;</code>
     *
     * @return The description.
     */
    im.turms.turms.pojo.bo.file.ImageFile.Description getDescription();

    /**
     * <code>.im.turms.proto.ImageFile.Description description = 1;</code>
     */
    im.turms.turms.pojo.bo.file.ImageFile.DescriptionOrBuilder getDescriptionOrBuilder();

  /**
   * <code>.google.protobuf.BytesValue data = 2;</code>
   * @return Whether the data field is set.
   */
  boolean hasData();
  /**
   * <code>.google.protobuf.BytesValue data = 2;</code>
   * @return The data.
   */
  com.google.protobuf.BytesValue getData();
  /**
   * <code>.google.protobuf.BytesValue data = 2;</code>
   */
  com.google.protobuf.BytesValueOrBuilder getDataOrBuilder();
}