// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: request/user/update_user_online_status_request.proto

package im.turms.turms.pojo.request;

/**
 * Protobuf type {@code im.turms.proto.UpdateUserOnlineStatusRequest}
 */
public  final class UpdateUserOnlineStatusRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:im.turms.proto.UpdateUserOnlineStatusRequest)
    UpdateUserOnlineStatusRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UpdateUserOnlineStatusRequest.newBuilder() to construct.
  private UpdateUserOnlineStatusRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UpdateUserOnlineStatusRequest() {
    userStatus_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new UpdateUserOnlineStatusRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UpdateUserOnlineStatusRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {
            int rawValue = input.readEnum();

            userStatus_ = rawValue;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return im.turms.turms.pojo.request.UpdateUserOnlineStatusRequestOuterClass.internal_static_im_turms_proto_UpdateUserOnlineStatusRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return im.turms.turms.pojo.request.UpdateUserOnlineStatusRequestOuterClass.internal_static_im_turms_proto_UpdateUserOnlineStatusRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest.class, im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest.Builder.class);
  }

  public static final int USER_STATUS_FIELD_NUMBER = 1;
  private int userStatus_;
  /**
   * <code>.im.turms.proto.UserStatus user_status = 1;</code>
   * @return The enum numeric value on the wire for userStatus.
   */
  public int getUserStatusValue() {
    return userStatus_;
  }
  /**
   * <code>.im.turms.proto.UserStatus user_status = 1;</code>
   * @return The userStatus.
   */
  public im.turms.turms.constant.UserStatus getUserStatus() {
    @SuppressWarnings("deprecation")
    im.turms.turms.constant.UserStatus result = im.turms.turms.constant.UserStatus.valueOf(userStatus_);
    return result == null ? im.turms.turms.constant.UserStatus.UNRECOGNIZED : result;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (userStatus_ != im.turms.turms.constant.UserStatus.AVAILABLE.getNumber()) {
      output.writeEnum(1, userStatus_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (userStatus_ != im.turms.turms.constant.UserStatus.AVAILABLE.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, userStatus_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest)) {
      return super.equals(obj);
    }
    im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest other = (im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest) obj;

    if (userStatus_ != other.userStatus_) return false;
    return unknownFields.equals(other.unknownFields);
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + USER_STATUS_FIELD_NUMBER;
    hash = (53 * hash) + userStatus_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code im.turms.proto.UpdateUserOnlineStatusRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:im.turms.proto.UpdateUserOnlineStatusRequest)
      im.turms.turms.pojo.request.UpdateUserOnlineStatusRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return im.turms.turms.pojo.request.UpdateUserOnlineStatusRequestOuterClass.internal_static_im_turms_proto_UpdateUserOnlineStatusRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return im.turms.turms.pojo.request.UpdateUserOnlineStatusRequestOuterClass.internal_static_im_turms_proto_UpdateUserOnlineStatusRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest.class, im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest.Builder.class);
    }

    // Construct using im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      userStatus_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return im.turms.turms.pojo.request.UpdateUserOnlineStatusRequestOuterClass.internal_static_im_turms_proto_UpdateUserOnlineStatusRequest_descriptor;
    }

    @java.lang.Override
    public im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest getDefaultInstanceForType() {
      return im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest.getDefaultInstance();
    }

    @java.lang.Override
    public im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest build() {
      im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest buildPartial() {
      im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest result = new im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest(this);
      result.userStatus_ = userStatus_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest) {
        return mergeFrom((im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest other) {
      if (other == im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest.getDefaultInstance()) return this;
      if (other.userStatus_ != 0) {
        setUserStatusValue(other.getUserStatusValue());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int userStatus_ = 0;
    /**
     * <code>.im.turms.proto.UserStatus user_status = 1;</code>
     * @return The enum numeric value on the wire for userStatus.
     */
    public int getUserStatusValue() {
      return userStatus_;
    }
    /**
     * <code>.im.turms.proto.UserStatus user_status = 1;</code>
     * @param value The enum numeric value on the wire for userStatus to set.
     * @return This builder for chaining.
     */
    public Builder setUserStatusValue(int value) {
      userStatus_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.im.turms.proto.UserStatus user_status = 1;</code>
     * @return The userStatus.
     */
    public im.turms.turms.constant.UserStatus getUserStatus() {
      @SuppressWarnings("deprecation")
      im.turms.turms.constant.UserStatus result = im.turms.turms.constant.UserStatus.valueOf(userStatus_);
      return result == null ? im.turms.turms.constant.UserStatus.UNRECOGNIZED : result;
    }
    /**
     * <code>.im.turms.proto.UserStatus user_status = 1;</code>
     * @param value The userStatus to set.
     * @return This builder for chaining.
     */
    public Builder setUserStatus(im.turms.turms.constant.UserStatus value) {
      if (value == null) {
        throw new NullPointerException();
      }

      userStatus_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.im.turms.proto.UserStatus user_status = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearUserStatus() {

      userStatus_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:im.turms.proto.UpdateUserOnlineStatusRequest)
  }

  // @@protoc_insertion_point(class_scope:im.turms.proto.UpdateUserOnlineStatusRequest)
  private static final im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest();
  }

  public static im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UpdateUserOnlineStatusRequest>
      PARSER = new com.google.protobuf.AbstractParser<UpdateUserOnlineStatusRequest>() {
    @java.lang.Override
    public UpdateUserOnlineStatusRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UpdateUserOnlineStatusRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UpdateUserOnlineStatusRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UpdateUserOnlineStatusRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public im.turms.turms.pojo.request.UpdateUserOnlineStatusRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

