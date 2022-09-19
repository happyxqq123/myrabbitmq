// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessageData.proto

package com.rabbitmq.protocol;

public final class MessageDataOuterClass {
  private MessageDataOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface MessageDataOrBuilder extends
      // @@protoc_insertion_point(interface_extends:MessageData)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 operation = 1;</code>
     * @return The operation.
     */
    int getOperation();

    /**
     * <code>.google.protobuf.Any data = 2;</code>
     * @return Whether the data field is set.
     */
    boolean hasData();
    /**
     * <code>.google.protobuf.Any data = 2;</code>
     * @return The data.
     */
    com.google.protobuf.Any getData();
    /**
     * <code>.google.protobuf.Any data = 2;</code>
     */
    com.google.protobuf.AnyOrBuilder getDataOrBuilder();

    /**
     * <code>int32 reqId = 3;</code>
     * @return The reqId.
     */
    int getReqId();
  }
  /**
   * Protobuf type {@code MessageData}
   */
  public static final class MessageData extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:MessageData)
      MessageDataOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use MessageData.newBuilder() to construct.
    private MessageData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private MessageData() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new MessageData();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private MessageData(
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

              operation_ = input.readInt32();
              break;
            }
            case 18: {
              com.google.protobuf.Any.Builder subBuilder = null;
              if (data_ != null) {
                subBuilder = data_.toBuilder();
              }
              data_ = input.readMessage(com.google.protobuf.Any.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(data_);
                data_ = subBuilder.buildPartial();
              }

              break;
            }
            case 24: {

              reqId_ = input.readInt32();
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
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
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
      return com.rabbitmq.protocol.MessageDataOuterClass.internal_static_MessageData_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.rabbitmq.protocol.MessageDataOuterClass.internal_static_MessageData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.rabbitmq.protocol.MessageDataOuterClass.MessageData.class, com.rabbitmq.protocol.MessageDataOuterClass.MessageData.Builder.class);
    }

    public static final int OPERATION_FIELD_NUMBER = 1;
    private int operation_;
    /**
     * <code>int32 operation = 1;</code>
     * @return The operation.
     */
    @java.lang.Override
    public int getOperation() {
      return operation_;
    }

    public static final int DATA_FIELD_NUMBER = 2;
    private com.google.protobuf.Any data_;
    /**
     * <code>.google.protobuf.Any data = 2;</code>
     * @return Whether the data field is set.
     */
    @java.lang.Override
    public boolean hasData() {
      return data_ != null;
    }
    /**
     * <code>.google.protobuf.Any data = 2;</code>
     * @return The data.
     */
    @java.lang.Override
    public com.google.protobuf.Any getData() {
      return data_ == null ? com.google.protobuf.Any.getDefaultInstance() : data_;
    }
    /**
     * <code>.google.protobuf.Any data = 2;</code>
     */
    @java.lang.Override
    public com.google.protobuf.AnyOrBuilder getDataOrBuilder() {
      return getData();
    }

    public static final int REQID_FIELD_NUMBER = 3;
    private int reqId_;
    /**
     * <code>int32 reqId = 3;</code>
     * @return The reqId.
     */
    @java.lang.Override
    public int getReqId() {
      return reqId_;
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
      if (operation_ != 0) {
        output.writeInt32(1, operation_);
      }
      if (data_ != null) {
        output.writeMessage(2, getData());
      }
      if (reqId_ != 0) {
        output.writeInt32(3, reqId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (operation_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, operation_);
      }
      if (data_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, getData());
      }
      if (reqId_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, reqId_);
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
      if (!(obj instanceof com.rabbitmq.protocol.MessageDataOuterClass.MessageData)) {
        return super.equals(obj);
      }
      com.rabbitmq.protocol.MessageDataOuterClass.MessageData other = (com.rabbitmq.protocol.MessageDataOuterClass.MessageData) obj;

      if (getOperation()
          != other.getOperation()) return false;
      if (hasData() != other.hasData()) return false;
      if (hasData()) {
        if (!getData()
            .equals(other.getData())) return false;
      }
      if (getReqId()
          != other.getReqId()) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + OPERATION_FIELD_NUMBER;
      hash = (53 * hash) + getOperation();
      if (hasData()) {
        hash = (37 * hash) + DATA_FIELD_NUMBER;
        hash = (53 * hash) + getData().hashCode();
      }
      hash = (37 * hash) + REQID_FIELD_NUMBER;
      hash = (53 * hash) + getReqId();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.rabbitmq.protocol.MessageDataOuterClass.MessageData parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.rabbitmq.protocol.MessageDataOuterClass.MessageData parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.rabbitmq.protocol.MessageDataOuterClass.MessageData parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.rabbitmq.protocol.MessageDataOuterClass.MessageData parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.rabbitmq.protocol.MessageDataOuterClass.MessageData parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.rabbitmq.protocol.MessageDataOuterClass.MessageData parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.rabbitmq.protocol.MessageDataOuterClass.MessageData parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.rabbitmq.protocol.MessageDataOuterClass.MessageData parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.rabbitmq.protocol.MessageDataOuterClass.MessageData parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.rabbitmq.protocol.MessageDataOuterClass.MessageData parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.rabbitmq.protocol.MessageDataOuterClass.MessageData parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.rabbitmq.protocol.MessageDataOuterClass.MessageData parseFrom(
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
    public static Builder newBuilder(com.rabbitmq.protocol.MessageDataOuterClass.MessageData prototype) {
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
     * Protobuf type {@code MessageData}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:MessageData)
        com.rabbitmq.protocol.MessageDataOuterClass.MessageDataOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.rabbitmq.protocol.MessageDataOuterClass.internal_static_MessageData_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.rabbitmq.protocol.MessageDataOuterClass.internal_static_MessageData_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.rabbitmq.protocol.MessageDataOuterClass.MessageData.class, com.rabbitmq.protocol.MessageDataOuterClass.MessageData.Builder.class);
      }

      // Construct using com.rabbitmq.protocol.MessageDataOuterClass.MessageData.newBuilder()
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
        operation_ = 0;

        if (dataBuilder_ == null) {
          data_ = null;
        } else {
          data_ = null;
          dataBuilder_ = null;
        }
        reqId_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.rabbitmq.protocol.MessageDataOuterClass.internal_static_MessageData_descriptor;
      }

      @java.lang.Override
      public com.rabbitmq.protocol.MessageDataOuterClass.MessageData getDefaultInstanceForType() {
        return com.rabbitmq.protocol.MessageDataOuterClass.MessageData.getDefaultInstance();
      }

      @java.lang.Override
      public com.rabbitmq.protocol.MessageDataOuterClass.MessageData build() {
        com.rabbitmq.protocol.MessageDataOuterClass.MessageData result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.rabbitmq.protocol.MessageDataOuterClass.MessageData buildPartial() {
        com.rabbitmq.protocol.MessageDataOuterClass.MessageData result = new com.rabbitmq.protocol.MessageDataOuterClass.MessageData(this);
        result.operation_ = operation_;
        if (dataBuilder_ == null) {
          result.data_ = data_;
        } else {
          result.data_ = dataBuilder_.build();
        }
        result.reqId_ = reqId_;
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
        if (other instanceof com.rabbitmq.protocol.MessageDataOuterClass.MessageData) {
          return mergeFrom((com.rabbitmq.protocol.MessageDataOuterClass.MessageData)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.rabbitmq.protocol.MessageDataOuterClass.MessageData other) {
        if (other == com.rabbitmq.protocol.MessageDataOuterClass.MessageData.getDefaultInstance()) return this;
        if (other.getOperation() != 0) {
          setOperation(other.getOperation());
        }
        if (other.hasData()) {
          mergeData(other.getData());
        }
        if (other.getReqId() != 0) {
          setReqId(other.getReqId());
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
        com.rabbitmq.protocol.MessageDataOuterClass.MessageData parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.rabbitmq.protocol.MessageDataOuterClass.MessageData) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int operation_ ;
      /**
       * <code>int32 operation = 1;</code>
       * @return The operation.
       */
      @java.lang.Override
      public int getOperation() {
        return operation_;
      }
      /**
       * <code>int32 operation = 1;</code>
       * @param value The operation to set.
       * @return This builder for chaining.
       */
      public Builder setOperation(int value) {
        
        operation_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 operation = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearOperation() {
        
        operation_ = 0;
        onChanged();
        return this;
      }

      private com.google.protobuf.Any data_;
      private com.google.protobuf.SingleFieldBuilderV3<
          com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> dataBuilder_;
      /**
       * <code>.google.protobuf.Any data = 2;</code>
       * @return Whether the data field is set.
       */
      public boolean hasData() {
        return dataBuilder_ != null || data_ != null;
      }
      /**
       * <code>.google.protobuf.Any data = 2;</code>
       * @return The data.
       */
      public com.google.protobuf.Any getData() {
        if (dataBuilder_ == null) {
          return data_ == null ? com.google.protobuf.Any.getDefaultInstance() : data_;
        } else {
          return dataBuilder_.getMessage();
        }
      }
      /**
       * <code>.google.protobuf.Any data = 2;</code>
       */
      public Builder setData(com.google.protobuf.Any value) {
        if (dataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          data_ = value;
          onChanged();
        } else {
          dataBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.google.protobuf.Any data = 2;</code>
       */
      public Builder setData(
          com.google.protobuf.Any.Builder builderForValue) {
        if (dataBuilder_ == null) {
          data_ = builderForValue.build();
          onChanged();
        } else {
          dataBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.google.protobuf.Any data = 2;</code>
       */
      public Builder mergeData(com.google.protobuf.Any value) {
        if (dataBuilder_ == null) {
          if (data_ != null) {
            data_ =
              com.google.protobuf.Any.newBuilder(data_).mergeFrom(value).buildPartial();
          } else {
            data_ = value;
          }
          onChanged();
        } else {
          dataBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.google.protobuf.Any data = 2;</code>
       */
      public Builder clearData() {
        if (dataBuilder_ == null) {
          data_ = null;
          onChanged();
        } else {
          data_ = null;
          dataBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.google.protobuf.Any data = 2;</code>
       */
      public com.google.protobuf.Any.Builder getDataBuilder() {
        
        onChanged();
        return getDataFieldBuilder().getBuilder();
      }
      /**
       * <code>.google.protobuf.Any data = 2;</code>
       */
      public com.google.protobuf.AnyOrBuilder getDataOrBuilder() {
        if (dataBuilder_ != null) {
          return dataBuilder_.getMessageOrBuilder();
        } else {
          return data_ == null ?
              com.google.protobuf.Any.getDefaultInstance() : data_;
        }
      }
      /**
       * <code>.google.protobuf.Any data = 2;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> 
          getDataFieldBuilder() {
        if (dataBuilder_ == null) {
          dataBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder>(
                  getData(),
                  getParentForChildren(),
                  isClean());
          data_ = null;
        }
        return dataBuilder_;
      }

      private int reqId_ ;
      /**
       * <code>int32 reqId = 3;</code>
       * @return The reqId.
       */
      @java.lang.Override
      public int getReqId() {
        return reqId_;
      }
      /**
       * <code>int32 reqId = 3;</code>
       * @param value The reqId to set.
       * @return This builder for chaining.
       */
      public Builder setReqId(int value) {
        
        reqId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 reqId = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearReqId() {
        
        reqId_ = 0;
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


      // @@protoc_insertion_point(builder_scope:MessageData)
    }

    // @@protoc_insertion_point(class_scope:MessageData)
    private static final com.rabbitmq.protocol.MessageDataOuterClass.MessageData DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.rabbitmq.protocol.MessageDataOuterClass.MessageData();
    }

    public static com.rabbitmq.protocol.MessageDataOuterClass.MessageData getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<MessageData>
        PARSER = new com.google.protobuf.AbstractParser<MessageData>() {
      @java.lang.Override
      public MessageData parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new MessageData(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<MessageData> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<MessageData> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.rabbitmq.protocol.MessageDataOuterClass.MessageData getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MessageData_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MessageData_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021MessageData.proto\032\031google/protobuf/any" +
      ".proto\"S\n\013MessageData\022\021\n\toperation\030\001 \001(\005" +
      "\022\"\n\004data\030\002 \001(\0132\024.google.protobuf.Any\022\r\n\005" +
      "reqId\030\003 \001(\005B\027\n\025com.rabbitmq.protocolb\006pr" +
      "oto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.AnyProto.getDescriptor(),
        });
    internal_static_MessageData_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_MessageData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MessageData_descriptor,
        new java.lang.String[] { "Operation", "Data", "ReqId", });
    com.google.protobuf.AnyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
