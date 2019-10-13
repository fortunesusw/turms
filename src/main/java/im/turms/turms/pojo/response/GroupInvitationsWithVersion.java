// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: response/group/group_invitations_with_version.proto

package im.turms.turms.pojo.response;

/**
 * Protobuf type {@code im.turms.proto.GroupInvitationsWithVersion}
 */
public  final class GroupInvitationsWithVersion extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:im.turms.proto.GroupInvitationsWithVersion)
    GroupInvitationsWithVersionOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GroupInvitationsWithVersion.newBuilder() to construct.
  private GroupInvitationsWithVersion(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GroupInvitationsWithVersion() {
    groupInvitations_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GroupInvitationsWithVersion();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GroupInvitationsWithVersion(
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
              groupInvitations_ = new java.util.ArrayList<im.turms.turms.pojo.dto.GroupInvitation>();
              mutable_bitField0_ |= 0x00000001;
            }
            groupInvitations_.add(
                input.readMessage(im.turms.turms.pojo.dto.GroupInvitation.parser(), extensionRegistry));
            break;
          }
          case 18: {
            com.google.protobuf.Int64Value.Builder subBuilder = null;
            if (lastUpdatedDate_ != null) {
              subBuilder = lastUpdatedDate_.toBuilder();
            }
            lastUpdatedDate_ = input.readMessage(com.google.protobuf.Int64Value.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(lastUpdatedDate_);
              lastUpdatedDate_ = subBuilder.buildPartial();
            }

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
        groupInvitations_ = java.util.Collections.unmodifiableList(groupInvitations_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return im.turms.turms.pojo.response.GroupInvitationsWithVersionOuterClass.internal_static_im_turms_proto_GroupInvitationsWithVersion_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return im.turms.turms.pojo.response.GroupInvitationsWithVersionOuterClass.internal_static_im_turms_proto_GroupInvitationsWithVersion_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            im.turms.turms.pojo.response.GroupInvitationsWithVersion.class, im.turms.turms.pojo.response.GroupInvitationsWithVersion.Builder.class);
  }

  public static final int GROUP_INVITATIONS_FIELD_NUMBER = 1;
  private java.util.List<im.turms.turms.pojo.dto.GroupInvitation> groupInvitations_;
  /**
   * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
   */
  public java.util.List<im.turms.turms.pojo.dto.GroupInvitation> getGroupInvitationsList() {
    return groupInvitations_;
  }
  /**
   * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
   */
  public java.util.List<? extends im.turms.turms.pojo.dto.GroupInvitationOrBuilder>
      getGroupInvitationsOrBuilderList() {
    return groupInvitations_;
  }
  /**
   * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
   */
  public int getGroupInvitationsCount() {
    return groupInvitations_.size();
  }
  /**
   * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
   */
  public im.turms.turms.pojo.dto.GroupInvitation getGroupInvitations(int index) {
    return groupInvitations_.get(index);
  }
  /**
   * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
   */
  public im.turms.turms.pojo.dto.GroupInvitationOrBuilder getGroupInvitationsOrBuilder(
      int index) {
    return groupInvitations_.get(index);
  }

  public static final int LAST_UPDATED_DATE_FIELD_NUMBER = 2;
  private com.google.protobuf.Int64Value lastUpdatedDate_;
  /**
   * <code>.google.protobuf.Int64Value last_updated_date = 2;</code>
   * @return Whether the lastUpdatedDate field is set.
   */
  public boolean hasLastUpdatedDate() {
    return lastUpdatedDate_ != null;
  }
  /**
   * <code>.google.protobuf.Int64Value last_updated_date = 2;</code>
   * @return The lastUpdatedDate.
   */
  public com.google.protobuf.Int64Value getLastUpdatedDate() {
    return lastUpdatedDate_ == null ? com.google.protobuf.Int64Value.getDefaultInstance() : lastUpdatedDate_;
  }
  /**
   * <code>.google.protobuf.Int64Value last_updated_date = 2;</code>
   */
  public com.google.protobuf.Int64ValueOrBuilder getLastUpdatedDateOrBuilder() {
    return getLastUpdatedDate();
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
    for (int i = 0; i < groupInvitations_.size(); i++) {
      output.writeMessage(1, groupInvitations_.get(i));
    }
    if (lastUpdatedDate_ != null) {
      output.writeMessage(2, getLastUpdatedDate());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < groupInvitations_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, groupInvitations_.get(i));
    }
    if (lastUpdatedDate_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getLastUpdatedDate());
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
    if (!(obj instanceof im.turms.turms.pojo.response.GroupInvitationsWithVersion)) {
      return super.equals(obj);
    }
    im.turms.turms.pojo.response.GroupInvitationsWithVersion other = (im.turms.turms.pojo.response.GroupInvitationsWithVersion) obj;

    if (!getGroupInvitationsList()
        .equals(other.getGroupInvitationsList())) return false;
    if (hasLastUpdatedDate() != other.hasLastUpdatedDate()) return false;
    if (hasLastUpdatedDate()) {
      if (!getLastUpdatedDate()
          .equals(other.getLastUpdatedDate())) return false;
    }
    return unknownFields.equals(other.unknownFields);
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getGroupInvitationsCount() > 0) {
      hash = (37 * hash) + GROUP_INVITATIONS_FIELD_NUMBER;
      hash = (53 * hash) + getGroupInvitationsList().hashCode();
    }
    if (hasLastUpdatedDate()) {
      hash = (37 * hash) + LAST_UPDATED_DATE_FIELD_NUMBER;
      hash = (53 * hash) + getLastUpdatedDate().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static im.turms.turms.pojo.response.GroupInvitationsWithVersion parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static im.turms.turms.pojo.response.GroupInvitationsWithVersion parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static im.turms.turms.pojo.response.GroupInvitationsWithVersion parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static im.turms.turms.pojo.response.GroupInvitationsWithVersion parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static im.turms.turms.pojo.response.GroupInvitationsWithVersion parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static im.turms.turms.pojo.response.GroupInvitationsWithVersion parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static im.turms.turms.pojo.response.GroupInvitationsWithVersion parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static im.turms.turms.pojo.response.GroupInvitationsWithVersion parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static im.turms.turms.pojo.response.GroupInvitationsWithVersion parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static im.turms.turms.pojo.response.GroupInvitationsWithVersion parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static im.turms.turms.pojo.response.GroupInvitationsWithVersion parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static im.turms.turms.pojo.response.GroupInvitationsWithVersion parseFrom(
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
  public static Builder newBuilder(im.turms.turms.pojo.response.GroupInvitationsWithVersion prototype) {
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
   * Protobuf type {@code im.turms.proto.GroupInvitationsWithVersion}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:im.turms.proto.GroupInvitationsWithVersion)
      im.turms.turms.pojo.response.GroupInvitationsWithVersionOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return im.turms.turms.pojo.response.GroupInvitationsWithVersionOuterClass.internal_static_im_turms_proto_GroupInvitationsWithVersion_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return im.turms.turms.pojo.response.GroupInvitationsWithVersionOuterClass.internal_static_im_turms_proto_GroupInvitationsWithVersion_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              im.turms.turms.pojo.response.GroupInvitationsWithVersion.class, im.turms.turms.pojo.response.GroupInvitationsWithVersion.Builder.class);
    }

    // Construct using im.turms.turms.pojo.response.GroupInvitationsWithVersion.newBuilder()
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
        getGroupInvitationsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (groupInvitationsBuilder_ == null) {
        groupInvitations_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        groupInvitationsBuilder_.clear();
      }
      if (lastUpdatedDateBuilder_ == null) {
        lastUpdatedDate_ = null;
      } else {
        lastUpdatedDate_ = null;
        lastUpdatedDateBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return im.turms.turms.pojo.response.GroupInvitationsWithVersionOuterClass.internal_static_im_turms_proto_GroupInvitationsWithVersion_descriptor;
    }

    @java.lang.Override
    public im.turms.turms.pojo.response.GroupInvitationsWithVersion getDefaultInstanceForType() {
      return im.turms.turms.pojo.response.GroupInvitationsWithVersion.getDefaultInstance();
    }

    @java.lang.Override
    public im.turms.turms.pojo.response.GroupInvitationsWithVersion build() {
      im.turms.turms.pojo.response.GroupInvitationsWithVersion result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public im.turms.turms.pojo.response.GroupInvitationsWithVersion buildPartial() {
      im.turms.turms.pojo.response.GroupInvitationsWithVersion result = new im.turms.turms.pojo.response.GroupInvitationsWithVersion(this);
      int from_bitField0_ = bitField0_;
      if (groupInvitationsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          groupInvitations_ = java.util.Collections.unmodifiableList(groupInvitations_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.groupInvitations_ = groupInvitations_;
      } else {
        result.groupInvitations_ = groupInvitationsBuilder_.build();
      }
      if (lastUpdatedDateBuilder_ == null) {
        result.lastUpdatedDate_ = lastUpdatedDate_;
      } else {
        result.lastUpdatedDate_ = lastUpdatedDateBuilder_.build();
      }
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
      if (other instanceof im.turms.turms.pojo.response.GroupInvitationsWithVersion) {
        return mergeFrom((im.turms.turms.pojo.response.GroupInvitationsWithVersion)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(im.turms.turms.pojo.response.GroupInvitationsWithVersion other) {
      if (other == im.turms.turms.pojo.response.GroupInvitationsWithVersion.getDefaultInstance()) return this;
      if (groupInvitationsBuilder_ == null) {
        if (!other.groupInvitations_.isEmpty()) {
          if (groupInvitations_.isEmpty()) {
            groupInvitations_ = other.groupInvitations_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureGroupInvitationsIsMutable();
            groupInvitations_.addAll(other.groupInvitations_);
          }
          onChanged();
        }
      } else {
        if (!other.groupInvitations_.isEmpty()) {
          if (groupInvitationsBuilder_.isEmpty()) {
            groupInvitationsBuilder_.dispose();
            groupInvitationsBuilder_ = null;
            groupInvitations_ = other.groupInvitations_;
            bitField0_ = (bitField0_ & ~0x00000001);
            groupInvitationsBuilder_ =
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getGroupInvitationsFieldBuilder() : null;
          } else {
            groupInvitationsBuilder_.addAllMessages(other.groupInvitations_);
          }
        }
      }
      if (other.hasLastUpdatedDate()) {
        mergeLastUpdatedDate(other.getLastUpdatedDate());
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
      im.turms.turms.pojo.response.GroupInvitationsWithVersion parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (im.turms.turms.pojo.response.GroupInvitationsWithVersion) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<im.turms.turms.pojo.dto.GroupInvitation> groupInvitations_ =
      java.util.Collections.emptyList();
    private void ensureGroupInvitationsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        groupInvitations_ = new java.util.ArrayList<im.turms.turms.pojo.dto.GroupInvitation>(groupInvitations_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        im.turms.turms.pojo.dto.GroupInvitation, im.turms.turms.pojo.dto.GroupInvitation.Builder, im.turms.turms.pojo.dto.GroupInvitationOrBuilder> groupInvitationsBuilder_;

    /**
     * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
     */
    public java.util.List<im.turms.turms.pojo.dto.GroupInvitation> getGroupInvitationsList() {
      if (groupInvitationsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(groupInvitations_);
      } else {
        return groupInvitationsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
     */
    public int getGroupInvitationsCount() {
      if (groupInvitationsBuilder_ == null) {
        return groupInvitations_.size();
      } else {
        return groupInvitationsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
     */
    public im.turms.turms.pojo.dto.GroupInvitation getGroupInvitations(int index) {
      if (groupInvitationsBuilder_ == null) {
        return groupInvitations_.get(index);
      } else {
        return groupInvitationsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
     */
    public Builder setGroupInvitations(
        int index, im.turms.turms.pojo.dto.GroupInvitation value) {
      if (groupInvitationsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureGroupInvitationsIsMutable();
        groupInvitations_.set(index, value);
        onChanged();
      } else {
        groupInvitationsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
     */
    public Builder setGroupInvitations(
        int index, im.turms.turms.pojo.dto.GroupInvitation.Builder builderForValue) {
      if (groupInvitationsBuilder_ == null) {
        ensureGroupInvitationsIsMutable();
        groupInvitations_.set(index, builderForValue.build());
        onChanged();
      } else {
        groupInvitationsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
     */
    public Builder addGroupInvitations(im.turms.turms.pojo.dto.GroupInvitation value) {
      if (groupInvitationsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureGroupInvitationsIsMutable();
        groupInvitations_.add(value);
        onChanged();
      } else {
        groupInvitationsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
     */
    public Builder addGroupInvitations(
        int index, im.turms.turms.pojo.dto.GroupInvitation value) {
      if (groupInvitationsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureGroupInvitationsIsMutable();
        groupInvitations_.add(index, value);
        onChanged();
      } else {
        groupInvitationsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
     */
    public Builder addGroupInvitations(
        im.turms.turms.pojo.dto.GroupInvitation.Builder builderForValue) {
      if (groupInvitationsBuilder_ == null) {
        ensureGroupInvitationsIsMutable();
        groupInvitations_.add(builderForValue.build());
        onChanged();
      } else {
        groupInvitationsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
     */
    public Builder addGroupInvitations(
        int index, im.turms.turms.pojo.dto.GroupInvitation.Builder builderForValue) {
      if (groupInvitationsBuilder_ == null) {
        ensureGroupInvitationsIsMutable();
        groupInvitations_.add(index, builderForValue.build());
        onChanged();
      } else {
        groupInvitationsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
     */
    public Builder addAllGroupInvitations(
        java.lang.Iterable<? extends im.turms.turms.pojo.dto.GroupInvitation> values) {
      if (groupInvitationsBuilder_ == null) {
        ensureGroupInvitationsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, groupInvitations_);
        onChanged();
      } else {
        groupInvitationsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
     */
    public Builder clearGroupInvitations() {
      if (groupInvitationsBuilder_ == null) {
        groupInvitations_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        groupInvitationsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
     */
    public Builder removeGroupInvitations(int index) {
      if (groupInvitationsBuilder_ == null) {
        ensureGroupInvitationsIsMutable();
        groupInvitations_.remove(index);
        onChanged();
      } else {
        groupInvitationsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
     */
    public im.turms.turms.pojo.dto.GroupInvitation.Builder getGroupInvitationsBuilder(
        int index) {
      return getGroupInvitationsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
     */
    public im.turms.turms.pojo.dto.GroupInvitationOrBuilder getGroupInvitationsOrBuilder(
        int index) {
      if (groupInvitationsBuilder_ == null) {
        return groupInvitations_.get(index);  } else {
        return groupInvitationsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
     */
    public java.util.List<? extends im.turms.turms.pojo.dto.GroupInvitationOrBuilder>
         getGroupInvitationsOrBuilderList() {
      if (groupInvitationsBuilder_ != null) {
        return groupInvitationsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(groupInvitations_);
      }
    }
    /**
     * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
     */
    public im.turms.turms.pojo.dto.GroupInvitation.Builder addGroupInvitationsBuilder() {
      return getGroupInvitationsFieldBuilder().addBuilder(
          im.turms.turms.pojo.dto.GroupInvitation.getDefaultInstance());
    }
    /**
     * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
     */
    public im.turms.turms.pojo.dto.GroupInvitation.Builder addGroupInvitationsBuilder(
        int index) {
      return getGroupInvitationsFieldBuilder().addBuilder(
          index, im.turms.turms.pojo.dto.GroupInvitation.getDefaultInstance());
    }
    /**
     * <code>repeated .im.turms.proto.GroupInvitation group_invitations = 1;</code>
     */
    public java.util.List<im.turms.turms.pojo.dto.GroupInvitation.Builder>
         getGroupInvitationsBuilderList() {
      return getGroupInvitationsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        im.turms.turms.pojo.dto.GroupInvitation, im.turms.turms.pojo.dto.GroupInvitation.Builder, im.turms.turms.pojo.dto.GroupInvitationOrBuilder>
        getGroupInvitationsFieldBuilder() {
      if (groupInvitationsBuilder_ == null) {
        groupInvitationsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            im.turms.turms.pojo.dto.GroupInvitation, im.turms.turms.pojo.dto.GroupInvitation.Builder, im.turms.turms.pojo.dto.GroupInvitationOrBuilder>(
                groupInvitations_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        groupInvitations_ = null;
      }
      return groupInvitationsBuilder_;
    }

    private com.google.protobuf.Int64Value lastUpdatedDate_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Int64Value, com.google.protobuf.Int64Value.Builder, com.google.protobuf.Int64ValueOrBuilder> lastUpdatedDateBuilder_;
    /**
     * <code>.google.protobuf.Int64Value last_updated_date = 2;</code>
     * @return Whether the lastUpdatedDate field is set.
     */
    public boolean hasLastUpdatedDate() {
      return lastUpdatedDateBuilder_ != null || lastUpdatedDate_ != null;
    }
    /**
     * <code>.google.protobuf.Int64Value last_updated_date = 2;</code>
     * @return The lastUpdatedDate.
     */
    public com.google.protobuf.Int64Value getLastUpdatedDate() {
      if (lastUpdatedDateBuilder_ == null) {
        return lastUpdatedDate_ == null ? com.google.protobuf.Int64Value.getDefaultInstance() : lastUpdatedDate_;
      } else {
        return lastUpdatedDateBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Int64Value last_updated_date = 2;</code>
     */
    public Builder setLastUpdatedDate(com.google.protobuf.Int64Value value) {
      if (lastUpdatedDateBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        lastUpdatedDate_ = value;
        onChanged();
      } else {
        lastUpdatedDateBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int64Value last_updated_date = 2;</code>
     */
    public Builder setLastUpdatedDate(
        com.google.protobuf.Int64Value.Builder builderForValue) {
      if (lastUpdatedDateBuilder_ == null) {
        lastUpdatedDate_ = builderForValue.build();
        onChanged();
      } else {
        lastUpdatedDateBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int64Value last_updated_date = 2;</code>
     */
    public Builder mergeLastUpdatedDate(com.google.protobuf.Int64Value value) {
      if (lastUpdatedDateBuilder_ == null) {
        if (lastUpdatedDate_ != null) {
          lastUpdatedDate_ =
            com.google.protobuf.Int64Value.newBuilder(lastUpdatedDate_).mergeFrom(value).buildPartial();
        } else {
          lastUpdatedDate_ = value;
        }
        onChanged();
      } else {
        lastUpdatedDateBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int64Value last_updated_date = 2;</code>
     */
    public Builder clearLastUpdatedDate() {
      if (lastUpdatedDateBuilder_ == null) {
        lastUpdatedDate_ = null;
        onChanged();
      } else {
        lastUpdatedDate_ = null;
        lastUpdatedDateBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int64Value last_updated_date = 2;</code>
     */
    public com.google.protobuf.Int64Value.Builder getLastUpdatedDateBuilder() {

      onChanged();
      return getLastUpdatedDateFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Int64Value last_updated_date = 2;</code>
     */
    public com.google.protobuf.Int64ValueOrBuilder getLastUpdatedDateOrBuilder() {
      if (lastUpdatedDateBuilder_ != null) {
        return lastUpdatedDateBuilder_.getMessageOrBuilder();
      } else {
        return lastUpdatedDate_ == null ?
            com.google.protobuf.Int64Value.getDefaultInstance() : lastUpdatedDate_;
      }
    }
    /**
     * <code>.google.protobuf.Int64Value last_updated_date = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Int64Value, com.google.protobuf.Int64Value.Builder, com.google.protobuf.Int64ValueOrBuilder>
        getLastUpdatedDateFieldBuilder() {
      if (lastUpdatedDateBuilder_ == null) {
        lastUpdatedDateBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Int64Value, com.google.protobuf.Int64Value.Builder, com.google.protobuf.Int64ValueOrBuilder>(
                getLastUpdatedDate(),
                getParentForChildren(),
                isClean());
        lastUpdatedDate_ = null;
      }
      return lastUpdatedDateBuilder_;
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


    // @@protoc_insertion_point(builder_scope:im.turms.proto.GroupInvitationsWithVersion)
  }

  // @@protoc_insertion_point(class_scope:im.turms.proto.GroupInvitationsWithVersion)
  private static final im.turms.turms.pojo.response.GroupInvitationsWithVersion DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new im.turms.turms.pojo.response.GroupInvitationsWithVersion();
  }

  public static im.turms.turms.pojo.response.GroupInvitationsWithVersion getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GroupInvitationsWithVersion>
      PARSER = new com.google.protobuf.AbstractParser<GroupInvitationsWithVersion>() {
    @java.lang.Override
    public GroupInvitationsWithVersion parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GroupInvitationsWithVersion(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GroupInvitationsWithVersion> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GroupInvitationsWithVersion> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public im.turms.turms.pojo.response.GroupInvitationsWithVersion getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

