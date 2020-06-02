// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ticket-sale.proto

package fisher.kafka.streams.proto;

public final class TicketSaleOuterClass {
  private TicketSaleOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface TicketSaleOrBuilder extends
      // @@protoc_insertion_point(interface_extends:fisher.kafka.streams.proto.TicketSale)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string title = 1;</code>
     */
    java.lang.String getTitle();
    /**
     * <code>optional string title = 1;</code>
     */
    com.google.protobuf.ByteString
        getTitleBytes();

    /**
     * <code>optional string sale_ts = 2;</code>
     */
    java.lang.String getSaleTs();
    /**
     * <code>optional string sale_ts = 2;</code>
     */
    com.google.protobuf.ByteString
        getSaleTsBytes();

    /**
     * <code>optional int32 ticket_total_value = 3;</code>
     */
    int getTicketTotalValue();
  }
  /**
   * Protobuf type {@code fisher.kafka.streams.proto.TicketSale}
   */
  public  static final class TicketSale extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:fisher.kafka.streams.proto.TicketSale)
      TicketSaleOrBuilder {
    // Use TicketSale.newBuilder() to construct.
    private TicketSale(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private TicketSale() {
      title_ = "";
      saleTs_ = "";
      ticketTotalValue_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private TicketSale(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              title_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              saleTs_ = s;
              break;
            }
            case 24: {

              ticketTotalValue_ = input.readInt32();
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
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return fisher.kafka.streams.proto.TicketSaleOuterClass.internal_static_fisher_kafka_streams_proto_TicketSale_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return fisher.kafka.streams.proto.TicketSaleOuterClass.internal_static_fisher_kafka_streams_proto_TicketSale_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale.class, fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale.Builder.class);
    }

    public static final int TITLE_FIELD_NUMBER = 1;
    private volatile java.lang.Object title_;
    /**
     * <code>optional string title = 1;</code>
     */
    public java.lang.String getTitle() {
      java.lang.Object ref = title_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        title_ = s;
        return s;
      }
    }
    /**
     * <code>optional string title = 1;</code>
     */
    public com.google.protobuf.ByteString
        getTitleBytes() {
      java.lang.Object ref = title_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        title_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SALE_TS_FIELD_NUMBER = 2;
    private volatile java.lang.Object saleTs_;
    /**
     * <code>optional string sale_ts = 2;</code>
     */
    public java.lang.String getSaleTs() {
      java.lang.Object ref = saleTs_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        saleTs_ = s;
        return s;
      }
    }
    /**
     * <code>optional string sale_ts = 2;</code>
     */
    public com.google.protobuf.ByteString
        getSaleTsBytes() {
      java.lang.Object ref = saleTs_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        saleTs_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TICKET_TOTAL_VALUE_FIELD_NUMBER = 3;
    private int ticketTotalValue_;
    /**
     * <code>optional int32 ticket_total_value = 3;</code>
     */
    public int getTicketTotalValue() {
      return ticketTotalValue_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getTitleBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, title_);
      }
      if (!getSaleTsBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, saleTs_);
      }
      if (ticketTotalValue_ != 0) {
        output.writeInt32(3, ticketTotalValue_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getTitleBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, title_);
      }
      if (!getSaleTsBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, saleTs_);
      }
      if (ticketTotalValue_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, ticketTotalValue_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale)) {
        return super.equals(obj);
      }
      fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale other = (fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale) obj;

      boolean result = true;
      result = result && getTitle()
          .equals(other.getTitle());
      result = result && getSaleTs()
          .equals(other.getSaleTs());
      result = result && (getTicketTotalValue()
          == other.getTicketTotalValue());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + TITLE_FIELD_NUMBER;
      hash = (53 * hash) + getTitle().hashCode();
      hash = (37 * hash) + SALE_TS_FIELD_NUMBER;
      hash = (53 * hash) + getSaleTs().hashCode();
      hash = (37 * hash) + TICKET_TOTAL_VALUE_FIELD_NUMBER;
      hash = (53 * hash) + getTicketTotalValue();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
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
     * Protobuf type {@code fisher.kafka.streams.proto.TicketSale}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:fisher.kafka.streams.proto.TicketSale)
        fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSaleOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return fisher.kafka.streams.proto.TicketSaleOuterClass.internal_static_fisher_kafka_streams_proto_TicketSale_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return fisher.kafka.streams.proto.TicketSaleOuterClass.internal_static_fisher_kafka_streams_proto_TicketSale_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale.class, fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale.Builder.class);
      }

      // Construct using fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale.newBuilder()
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
      public Builder clear() {
        super.clear();
        title_ = "";

        saleTs_ = "";

        ticketTotalValue_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return fisher.kafka.streams.proto.TicketSaleOuterClass.internal_static_fisher_kafka_streams_proto_TicketSale_descriptor;
      }

      public fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale getDefaultInstanceForType() {
        return fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale.getDefaultInstance();
      }

      public fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale build() {
        fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale buildPartial() {
        fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale result = new fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale(this);
        result.title_ = title_;
        result.saleTs_ = saleTs_;
        result.ticketTotalValue_ = ticketTotalValue_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale) {
          return mergeFrom((fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale other) {
        if (other == fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale.getDefaultInstance()) return this;
        if (!other.getTitle().isEmpty()) {
          title_ = other.title_;
          onChanged();
        }
        if (!other.getSaleTs().isEmpty()) {
          saleTs_ = other.saleTs_;
          onChanged();
        }
        if (other.getTicketTotalValue() != 0) {
          setTicketTotalValue(other.getTicketTotalValue());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object title_ = "";
      /**
       * <code>optional string title = 1;</code>
       */
      public java.lang.String getTitle() {
        java.lang.Object ref = title_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          title_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string title = 1;</code>
       */
      public com.google.protobuf.ByteString
          getTitleBytes() {
        java.lang.Object ref = title_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          title_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string title = 1;</code>
       */
      public Builder setTitle(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        title_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string title = 1;</code>
       */
      public Builder clearTitle() {
        
        title_ = getDefaultInstance().getTitle();
        onChanged();
        return this;
      }
      /**
       * <code>optional string title = 1;</code>
       */
      public Builder setTitleBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        title_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object saleTs_ = "";
      /**
       * <code>optional string sale_ts = 2;</code>
       */
      public java.lang.String getSaleTs() {
        java.lang.Object ref = saleTs_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          saleTs_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string sale_ts = 2;</code>
       */
      public com.google.protobuf.ByteString
          getSaleTsBytes() {
        java.lang.Object ref = saleTs_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          saleTs_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string sale_ts = 2;</code>
       */
      public Builder setSaleTs(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        saleTs_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string sale_ts = 2;</code>
       */
      public Builder clearSaleTs() {
        
        saleTs_ = getDefaultInstance().getSaleTs();
        onChanged();
        return this;
      }
      /**
       * <code>optional string sale_ts = 2;</code>
       */
      public Builder setSaleTsBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        saleTs_ = value;
        onChanged();
        return this;
      }

      private int ticketTotalValue_ ;
      /**
       * <code>optional int32 ticket_total_value = 3;</code>
       */
      public int getTicketTotalValue() {
        return ticketTotalValue_;
      }
      /**
       * <code>optional int32 ticket_total_value = 3;</code>
       */
      public Builder setTicketTotalValue(int value) {
        
        ticketTotalValue_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 ticket_total_value = 3;</code>
       */
      public Builder clearTicketTotalValue() {
        
        ticketTotalValue_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:fisher.kafka.streams.proto.TicketSale)
    }

    // @@protoc_insertion_point(class_scope:fisher.kafka.streams.proto.TicketSale)
    private static final fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale();
    }

    public static fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<TicketSale>
        PARSER = new com.google.protobuf.AbstractParser<TicketSale>() {
      public TicketSale parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new TicketSale(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<TicketSale> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<TicketSale> getParserForType() {
      return PARSER;
    }

    public fisher.kafka.streams.proto.TicketSaleOuterClass.TicketSale getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_fisher_kafka_streams_proto_TicketSale_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_fisher_kafka_streams_proto_TicketSale_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021ticket-sale.proto\022\032fisher.kafka.stream" +
      "s.proto\"H\n\nTicketSale\022\r\n\005title\030\001 \001(\t\022\017\n\007" +
      "sale_ts\030\002 \001(\t\022\032\n\022ticket_total_value\030\003 \001(" +
      "\005b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_fisher_kafka_streams_proto_TicketSale_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_fisher_kafka_streams_proto_TicketSale_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_fisher_kafka_streams_proto_TicketSale_descriptor,
        new java.lang.String[] { "Title", "SaleTs", "TicketTotalValue", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
