// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: model/message/message_statuses.proto

package im.turms.turms.pojo.bo.message;

/**
 * Protobuf type {@code im.turms.proto.MessageStatuses}
 */
public  final class MessageStatuses extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:im.turms.proto.MessageStatuses)
    MessageStatusesOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MessageStatuses.newBuilder() to construct.
  private MessageStatuses(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MessageStatuses() {
    messageStatuses_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
          UnusedPrivateParameter unused) {
    return new MessageStatuses();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }

  // @@protoc_insertion_point(class_scope:im.turms.proto.MessageStatuses)
  private static final im.turms.turms.pojo.bo.message.MessageStatuses DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new im.turms.turms.pojo.bo.message.MessageStatuses();
  }

  private java.util.List<im.turms.turms.pojo.bo.message.MessageStatus> messageStatuses_;

  public static final int MESSAGE_STATUSES_FIELD_NUMBER = 1;

  private MessageStatuses(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              messageStatuses_ = new java.util.ArrayList<im.turms.turms.pojo.bo.message.MessageStatus>();
              mutable_bitField0_ |= 0x00000001;
            }
            messageStatuses_.add(
                    input.readMessage(im.turms.turms.pojo.bo.message.MessageStatus.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        messageStatuses_ = java.util.Collections.unmodifiableList(messageStatuses_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor
  getDescriptor() {
    return im.turms.turms.pojo.bo.message.MessageStatusesOuterClass.internal_static_im_turms_proto_MessageStatuses_descriptor;
  }

  public static im.turms.turms.pojo.bo.message.MessageStatuses parseFrom(
          java.nio.ByteBuffer data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  /**
   * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
   */
  public int getMessageStatusesCount() {
    return messageStatuses_.size();
  }

  public static im.turms.turms.pojo.bo.message.MessageStatuses parseFrom(
          java.nio.ByteBuffer data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static im.turms.turms.pojo.bo.message.MessageStatuses parseFrom(
          com.google.protobuf.ByteString data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
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
    for (int i = 0; i < messageStatuses_.size(); i++) {
      output.writeMessage(1, messageStatuses_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < messageStatuses_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
              .computeMessageSize(1, messageStatuses_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  public static im.turms.turms.pojo.bo.message.MessageStatuses parseFrom(
          com.google.protobuf.ByteString data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getMessageStatusesCount() > 0) {
      hash = (37 * hash) + MESSAGE_STATUSES_FIELD_NUMBER;
      hash = (53 * hash) + getMessageStatusesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static im.turms.turms.pojo.bo.message.MessageStatuses parseFrom(byte[] data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static im.turms.turms.pojo.bo.message.MessageStatuses parseFrom(
          byte[] data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static im.turms.turms.pojo.bo.message.MessageStatuses parseFrom(java.io.InputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input);
  }

  public static im.turms.turms.pojo.bo.message.MessageStatuses parseFrom(
          java.io.InputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static im.turms.turms.pojo.bo.message.MessageStatuses parseDelimitedFrom(java.io.InputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseDelimitedWithIOException(PARSER, input);
  }

  public static im.turms.turms.pojo.bo.message.MessageStatuses parseDelimitedFrom(
          java.io.InputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }

  public static im.turms.turms.pojo.bo.message.MessageStatuses parseFrom(
          com.google.protobuf.CodedInputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input);
  }

  public static im.turms.turms.pojo.bo.message.MessageStatuses parseFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static Builder newBuilder(im.turms.turms.pojo.bo.message.MessageStatuses prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public static im.turms.turms.pojo.bo.message.MessageStatuses getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
  internalGetFieldAccessorTable() {
    return im.turms.turms.pojo.bo.message.MessageStatusesOuterClass.internal_static_im_turms_proto_MessageStatuses_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                    im.turms.turms.pojo.bo.message.MessageStatuses.class, im.turms.turms.pojo.bo.message.MessageStatuses.Builder.class);
  }

  /**
   * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
   */
  public java.util.List<im.turms.turms.pojo.bo.message.MessageStatus> getMessageStatusesList() {
    return messageStatuses_;
  }

  @java.lang.Override
  public Builder newBuilderForType() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  /**
   * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
   */
  public java.util.List<? extends im.turms.turms.pojo.bo.message.MessageStatusOrBuilder>
  getMessageStatusesOrBuilderList() {
    return messageStatuses_;
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
   * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
   */
  public im.turms.turms.pojo.bo.message.MessageStatus getMessageStatuses(int index) {
    return messageStatuses_.get(index);
  }

  /**
   * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
   */
  public im.turms.turms.pojo.bo.message.MessageStatusOrBuilder getMessageStatusesOrBuilder(
          int index) {
    return messageStatuses_.get(index);
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof im.turms.turms.pojo.bo.message.MessageStatuses)) {
      return super.equals(obj);
    }
    im.turms.turms.pojo.bo.message.MessageStatuses other = (im.turms.turms.pojo.bo.message.MessageStatuses) obj;

    if (!getMessageStatusesList()
            .equals(other.getMessageStatusesList())) return false;
    return unknownFields.equals(other.unknownFields);
  }

  @java.lang.Override
  public im.turms.turms.pojo.bo.message.MessageStatuses getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MessageStatuses>
          PARSER = new com.google.protobuf.AbstractParser<MessageStatuses>() {
    @java.lang.Override
    public MessageStatuses parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return new MessageStatuses(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MessageStatuses> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MessageStatuses> getParserForType() {
    return PARSER;
  }

  /**
   * Protobuf type {@code im.turms.proto.MessageStatuses}
   */
  public static final class Builder extends
          com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
          // @@protoc_insertion_point(builder_implements:im.turms.proto.MessageStatuses)
          im.turms.turms.pojo.bo.message.MessageStatusesOrBuilder {
    private java.util.List<im.turms.turms.pojo.bo.message.MessageStatus> messageStatuses_ =
            java.util.Collections.emptyList();
    private com.google.protobuf.RepeatedFieldBuilderV3<
            im.turms.turms.pojo.bo.message.MessageStatus, im.turms.turms.pojo.bo.message.MessageStatus.Builder, im.turms.turms.pojo.bo.message.MessageStatusOrBuilder> messageStatusesBuilder_;

    // Construct using im.turms.turms.pojo.bo.message.MessageStatuses.newBuilder()
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
        getMessageStatusesFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (messageStatusesBuilder_ == null) {
        messageStatuses_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        messageStatusesBuilder_.clear();
      }
      return this;
    }

    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return im.turms.turms.pojo.bo.message.MessageStatusesOuterClass.internal_static_im_turms_proto_MessageStatuses_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return im.turms.turms.pojo.bo.message.MessageStatusesOuterClass.internal_static_im_turms_proto_MessageStatuses_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      im.turms.turms.pojo.bo.message.MessageStatuses.class, im.turms.turms.pojo.bo.message.MessageStatuses.Builder.class);
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
    getDescriptorForType() {
      return im.turms.turms.pojo.bo.message.MessageStatusesOuterClass.internal_static_im_turms_proto_MessageStatuses_descriptor;
    }

    @java.lang.Override
    public im.turms.turms.pojo.bo.message.MessageStatuses getDefaultInstanceForType() {
      return im.turms.turms.pojo.bo.message.MessageStatuses.getDefaultInstance();
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
    public im.turms.turms.pojo.bo.message.MessageStatuses build() {
      im.turms.turms.pojo.bo.message.MessageStatuses result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public im.turms.turms.pojo.bo.message.MessageStatuses buildPartial() {
      im.turms.turms.pojo.bo.message.MessageStatuses result = new im.turms.turms.pojo.bo.message.MessageStatuses(this);
      int from_bitField0_ = bitField0_;
      if (messageStatusesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          messageStatuses_ = java.util.Collections.unmodifiableList(messageStatuses_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.messageStatuses_ = messageStatuses_;
      } else {
        result.messageStatuses_ = messageStatusesBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof im.turms.turms.pojo.bo.message.MessageStatuses) {
        return mergeFrom((im.turms.turms.pojo.bo.message.MessageStatuses) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    private int bitField0_;

    public Builder mergeFrom(im.turms.turms.pojo.bo.message.MessageStatuses other) {
      if (other == im.turms.turms.pojo.bo.message.MessageStatuses.getDefaultInstance()) return this;
      if (messageStatusesBuilder_ == null) {
        if (!other.messageStatuses_.isEmpty()) {
          if (messageStatuses_.isEmpty()) {
            messageStatuses_ = other.messageStatuses_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureMessageStatusesIsMutable();
            messageStatuses_.addAll(other.messageStatuses_);
          }
          onChanged();
        }
      } else {
        if (!other.messageStatuses_.isEmpty()) {
          if (messageStatusesBuilder_.isEmpty()) {
            messageStatusesBuilder_.dispose();
            messageStatusesBuilder_ = null;
            messageStatuses_ = other.messageStatuses_;
            bitField0_ = (bitField0_ & ~0x00000001);
            messageStatusesBuilder_ =
                    com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                            getMessageStatusesFieldBuilder() : null;
          } else {
            messageStatusesBuilder_.addAllMessages(other.messageStatuses_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      im.turms.turms.pojo.bo.message.MessageStatuses parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (im.turms.turms.pojo.bo.message.MessageStatuses) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private void ensureMessageStatusesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        messageStatuses_ = new java.util.ArrayList<im.turms.turms.pojo.bo.message.MessageStatus>(messageStatuses_);
        bitField0_ |= 0x00000001;
      }
    }

    /**
     * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
     */
    public java.util.List<im.turms.turms.pojo.bo.message.MessageStatus> getMessageStatusesList() {
      if (messageStatusesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(messageStatuses_);
      } else {
        return messageStatusesBuilder_.getMessageList();
      }
    }

    /**
     * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
     */
    public int getMessageStatusesCount() {
      if (messageStatusesBuilder_ == null) {
        return messageStatuses_.size();
      } else {
        return messageStatusesBuilder_.getCount();
      }
    }

    /**
     * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
     */
    public im.turms.turms.pojo.bo.message.MessageStatus getMessageStatuses(int index) {
      if (messageStatusesBuilder_ == null) {
        return messageStatuses_.get(index);
      } else {
        return messageStatusesBuilder_.getMessage(index);
      }
    }

    /**
     * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
     */
    public Builder setMessageStatuses(
            int index, im.turms.turms.pojo.bo.message.MessageStatus value) {
      if (messageStatusesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMessageStatusesIsMutable();
        messageStatuses_.set(index, value);
        onChanged();
      } else {
        messageStatusesBuilder_.setMessage(index, value);
      }
      return this;
    }

    /**
     * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
     */
    public Builder setMessageStatuses(
            int index, im.turms.turms.pojo.bo.message.MessageStatus.Builder builderForValue) {
      if (messageStatusesBuilder_ == null) {
        ensureMessageStatusesIsMutable();
        messageStatuses_.set(index, builderForValue.build());
        onChanged();
      } else {
        messageStatusesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }

    /**
     * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
     */
    public Builder addMessageStatuses(im.turms.turms.pojo.bo.message.MessageStatus value) {
      if (messageStatusesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMessageStatusesIsMutable();
        messageStatuses_.add(value);
        onChanged();
      } else {
        messageStatusesBuilder_.addMessage(value);
      }
      return this;
    }

    /**
     * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
     */
    public Builder addMessageStatuses(
            int index, im.turms.turms.pojo.bo.message.MessageStatus value) {
      if (messageStatusesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMessageStatusesIsMutable();
        messageStatuses_.add(index, value);
        onChanged();
      } else {
        messageStatusesBuilder_.addMessage(index, value);
      }
      return this;
    }

    /**
     * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
     */
    public Builder addMessageStatuses(
            im.turms.turms.pojo.bo.message.MessageStatus.Builder builderForValue) {
      if (messageStatusesBuilder_ == null) {
        ensureMessageStatusesIsMutable();
        messageStatuses_.add(builderForValue.build());
        onChanged();
      } else {
        messageStatusesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }

    /**
     * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
     */
    public Builder addMessageStatuses(
            int index, im.turms.turms.pojo.bo.message.MessageStatus.Builder builderForValue) {
      if (messageStatusesBuilder_ == null) {
        ensureMessageStatusesIsMutable();
        messageStatuses_.add(index, builderForValue.build());
        onChanged();
      } else {
        messageStatusesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }

    /**
     * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
     */
    public Builder addAllMessageStatuses(
            java.lang.Iterable<? extends im.turms.turms.pojo.bo.message.MessageStatus> values) {
      if (messageStatusesBuilder_ == null) {
        ensureMessageStatusesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
                values, messageStatuses_);
        onChanged();
      } else {
        messageStatusesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
     */
    public Builder clearMessageStatuses() {
      if (messageStatusesBuilder_ == null) {
        messageStatuses_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        messageStatusesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
     */
    public Builder removeMessageStatuses(int index) {
      if (messageStatusesBuilder_ == null) {
        ensureMessageStatusesIsMutable();
        messageStatuses_.remove(index);
        onChanged();
      } else {
        messageStatusesBuilder_.remove(index);
      }
      return this;
    }

    /**
     * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
     */
    public im.turms.turms.pojo.bo.message.MessageStatus.Builder getMessageStatusesBuilder(
            int index) {
      return getMessageStatusesFieldBuilder().getBuilder(index);
    }

    /**
     * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
     */
    public im.turms.turms.pojo.bo.message.MessageStatusOrBuilder getMessageStatusesOrBuilder(
            int index) {
      if (messageStatusesBuilder_ == null) {
        return messageStatuses_.get(index);
      } else {
        return messageStatusesBuilder_.getMessageOrBuilder(index);
      }
    }

    /**
     * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
     */
    public java.util.List<? extends im.turms.turms.pojo.bo.message.MessageStatusOrBuilder>
    getMessageStatusesOrBuilderList() {
      if (messageStatusesBuilder_ != null) {
        return messageStatusesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(messageStatuses_);
      }
    }

    /**
     * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
     */
    public im.turms.turms.pojo.bo.message.MessageStatus.Builder addMessageStatusesBuilder() {
      return getMessageStatusesFieldBuilder().addBuilder(
              im.turms.turms.pojo.bo.message.MessageStatus.getDefaultInstance());
    }

    /**
     * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
     */
    public im.turms.turms.pojo.bo.message.MessageStatus.Builder addMessageStatusesBuilder(
            int index) {
      return getMessageStatusesFieldBuilder().addBuilder(
              index, im.turms.turms.pojo.bo.message.MessageStatus.getDefaultInstance());
    }

    /**
     * <code>repeated .im.turms.proto.MessageStatus message_statuses = 1;</code>
     */
    public java.util.List<im.turms.turms.pojo.bo.message.MessageStatus.Builder>
    getMessageStatusesBuilderList() {
      return getMessageStatusesFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            im.turms.turms.pojo.bo.message.MessageStatus, im.turms.turms.pojo.bo.message.MessageStatus.Builder, im.turms.turms.pojo.bo.message.MessageStatusOrBuilder>
    getMessageStatusesFieldBuilder() {
      if (messageStatusesBuilder_ == null) {
        messageStatusesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                im.turms.turms.pojo.bo.message.MessageStatus, im.turms.turms.pojo.bo.message.MessageStatus.Builder, im.turms.turms.pojo.bo.message.MessageStatusOrBuilder>(
                messageStatuses_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        messageStatuses_ = null;
      }
      return messageStatusesBuilder_;
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


    // @@protoc_insertion_point(builder_scope:im.turms.proto.MessageStatuses)
  }

}
