// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: yearly-movie-figures.proto

package fisher.kafka.streams.proto;

public final class YearlyMovieFiguresOuterClass {
  private YearlyMovieFiguresOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface YearlyMovieFiguresOrBuilder extends
      // @@protoc_insertion_point(interface_extends:fisher.kafka.streams.proto.YearlyMovieFigures)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 release_year = 1;</code>
     * @return The releaseYear.
     */
    int getReleaseYear();

    /**
     * <code>int32 min_total_sales = 2;</code>
     * @return The minTotalSales.
     */
    int getMinTotalSales();

    /**
     * <code>int32 max_total_sales = 3;</code>
     * @return The maxTotalSales.
     */
    int getMaxTotalSales();
  }
  /**
   * Protobuf type {@code fisher.kafka.streams.proto.YearlyMovieFigures}
   */
  public  static final class YearlyMovieFigures extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:fisher.kafka.streams.proto.YearlyMovieFigures)
      YearlyMovieFiguresOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use YearlyMovieFigures.newBuilder() to construct.
    private YearlyMovieFigures(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private YearlyMovieFigures() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new YearlyMovieFigures();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private YearlyMovieFigures(
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

              releaseYear_ = input.readInt32();
              break;
            }
            case 16: {

              minTotalSales_ = input.readInt32();
              break;
            }
            case 24: {

              maxTotalSales_ = input.readInt32();
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
      return fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.internal_static_fisher_kafka_streams_proto_YearlyMovieFigures_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.internal_static_fisher_kafka_streams_proto_YearlyMovieFigures_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures.class, fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures.Builder.class);
    }

    public static final int RELEASE_YEAR_FIELD_NUMBER = 1;
    private int releaseYear_;
    /**
     * <code>int32 release_year = 1;</code>
     * @return The releaseYear.
     */
    public int getReleaseYear() {
      return releaseYear_;
    }

    public static final int MIN_TOTAL_SALES_FIELD_NUMBER = 2;
    private int minTotalSales_;
    /**
     * <code>int32 min_total_sales = 2;</code>
     * @return The minTotalSales.
     */
    public int getMinTotalSales() {
      return minTotalSales_;
    }

    public static final int MAX_TOTAL_SALES_FIELD_NUMBER = 3;
    private int maxTotalSales_;
    /**
     * <code>int32 max_total_sales = 3;</code>
     * @return The maxTotalSales.
     */
    public int getMaxTotalSales() {
      return maxTotalSales_;
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
      if (releaseYear_ != 0) {
        output.writeInt32(1, releaseYear_);
      }
      if (minTotalSales_ != 0) {
        output.writeInt32(2, minTotalSales_);
      }
      if (maxTotalSales_ != 0) {
        output.writeInt32(3, maxTotalSales_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (releaseYear_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, releaseYear_);
      }
      if (minTotalSales_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, minTotalSales_);
      }
      if (maxTotalSales_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, maxTotalSales_);
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
      if (!(obj instanceof fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures)) {
        return super.equals(obj);
      }
      fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures other = (fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures) obj;

      if (getReleaseYear()
          != other.getReleaseYear()) return false;
      if (getMinTotalSales()
          != other.getMinTotalSales()) return false;
      if (getMaxTotalSales()
          != other.getMaxTotalSales()) return false;
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
      hash = (37 * hash) + RELEASE_YEAR_FIELD_NUMBER;
      hash = (53 * hash) + getReleaseYear();
      hash = (37 * hash) + MIN_TOTAL_SALES_FIELD_NUMBER;
      hash = (53 * hash) + getMinTotalSales();
      hash = (37 * hash) + MAX_TOTAL_SALES_FIELD_NUMBER;
      hash = (53 * hash) + getMaxTotalSales();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures parseFrom(
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
    public static Builder newBuilder(fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures prototype) {
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
     * Protobuf type {@code fisher.kafka.streams.proto.YearlyMovieFigures}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:fisher.kafka.streams.proto.YearlyMovieFigures)
        fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFiguresOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.internal_static_fisher_kafka_streams_proto_YearlyMovieFigures_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.internal_static_fisher_kafka_streams_proto_YearlyMovieFigures_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures.class, fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures.Builder.class);
      }

      // Construct using fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures.newBuilder()
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
        releaseYear_ = 0;

        minTotalSales_ = 0;

        maxTotalSales_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.internal_static_fisher_kafka_streams_proto_YearlyMovieFigures_descriptor;
      }

      @java.lang.Override
      public fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures getDefaultInstanceForType() {
        return fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures.getDefaultInstance();
      }

      @java.lang.Override
      public fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures build() {
        fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures buildPartial() {
        fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures result = new fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures(this);
        result.releaseYear_ = releaseYear_;
        result.minTotalSales_ = minTotalSales_;
        result.maxTotalSales_ = maxTotalSales_;
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
        if (other instanceof fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures) {
          return mergeFrom((fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures other) {
        if (other == fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures.getDefaultInstance()) return this;
        if (other.getReleaseYear() != 0) {
          setReleaseYear(other.getReleaseYear());
        }
        if (other.getMinTotalSales() != 0) {
          setMinTotalSales(other.getMinTotalSales());
        }
        if (other.getMaxTotalSales() != 0) {
          setMaxTotalSales(other.getMaxTotalSales());
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
        fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int releaseYear_ ;
      /**
       * <code>int32 release_year = 1;</code>
       * @return The releaseYear.
       */
      public int getReleaseYear() {
        return releaseYear_;
      }
      /**
       * <code>int32 release_year = 1;</code>
       * @param value The releaseYear to set.
       * @return This builder for chaining.
       */
      public Builder setReleaseYear(int value) {
        
        releaseYear_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 release_year = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearReleaseYear() {
        
        releaseYear_ = 0;
        onChanged();
        return this;
      }

      private int minTotalSales_ ;
      /**
       * <code>int32 min_total_sales = 2;</code>
       * @return The minTotalSales.
       */
      public int getMinTotalSales() {
        return minTotalSales_;
      }
      /**
       * <code>int32 min_total_sales = 2;</code>
       * @param value The minTotalSales to set.
       * @return This builder for chaining.
       */
      public Builder setMinTotalSales(int value) {
        
        minTotalSales_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 min_total_sales = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearMinTotalSales() {
        
        minTotalSales_ = 0;
        onChanged();
        return this;
      }

      private int maxTotalSales_ ;
      /**
       * <code>int32 max_total_sales = 3;</code>
       * @return The maxTotalSales.
       */
      public int getMaxTotalSales() {
        return maxTotalSales_;
      }
      /**
       * <code>int32 max_total_sales = 3;</code>
       * @param value The maxTotalSales to set.
       * @return This builder for chaining.
       */
      public Builder setMaxTotalSales(int value) {
        
        maxTotalSales_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 max_total_sales = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearMaxTotalSales() {
        
        maxTotalSales_ = 0;
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


      // @@protoc_insertion_point(builder_scope:fisher.kafka.streams.proto.YearlyMovieFigures)
    }

    // @@protoc_insertion_point(class_scope:fisher.kafka.streams.proto.YearlyMovieFigures)
    private static final fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures();
    }

    public static fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<YearlyMovieFigures>
        PARSER = new com.google.protobuf.AbstractParser<YearlyMovieFigures>() {
      @java.lang.Override
      public YearlyMovieFigures parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new YearlyMovieFigures(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<YearlyMovieFigures> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<YearlyMovieFigures> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass.YearlyMovieFigures getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_fisher_kafka_streams_proto_YearlyMovieFigures_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_fisher_kafka_streams_proto_YearlyMovieFigures_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\032yearly-movie-figures.proto\022\032fisher.kaf" +
      "ka.streams.proto\"\\\n\022YearlyMovieFigures\022\024" +
      "\n\014release_year\030\001 \001(\005\022\027\n\017min_total_sales\030" +
      "\002 \001(\005\022\027\n\017max_total_sales\030\003 \001(\005b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_fisher_kafka_streams_proto_YearlyMovieFigures_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_fisher_kafka_streams_proto_YearlyMovieFigures_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_fisher_kafka_streams_proto_YearlyMovieFigures_descriptor,
        new java.lang.String[] { "ReleaseYear", "MinTotalSales", "MaxTotalSales", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
