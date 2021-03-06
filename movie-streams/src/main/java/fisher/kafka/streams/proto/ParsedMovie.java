// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: parsed-movie.proto

package fisher.kafka.streams.proto;

public final class ParsedMovie {
  private ParsedMovie() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface MovieOrBuilder extends
      // @@protoc_insertion_point(interface_extends:fisher.kafka.streams.proto.Movie)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional uint64 id = 1;</code>
     */
    long getId();

    /**
     * <code>optional string title = 2;</code>
     */
    java.lang.String getTitle();
    /**
     * <code>optional string title = 2;</code>
     */
    com.google.protobuf.ByteString
        getTitleBytes();

    /**
     * <code>optional uint32 release_year = 3;</code>
     */
    int getReleaseYear();

    /**
     * <code>optional string genre = 4;</code>
     */
    java.lang.String getGenre();
    /**
     * <code>optional string genre = 4;</code>
     */
    com.google.protobuf.ByteString
        getGenreBytes();
  }
  /**
   * Protobuf type {@code fisher.kafka.streams.proto.Movie}
   */
  public  static final class Movie extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:fisher.kafka.streams.proto.Movie)
      MovieOrBuilder {
    // Use Movie.newBuilder() to construct.
    private Movie(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Movie() {
      id_ = 0L;
      title_ = "";
      releaseYear_ = 0;
      genre_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Movie(
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
            case 8: {

              id_ = input.readUInt64();
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              title_ = s;
              break;
            }
            case 24: {

              releaseYear_ = input.readUInt32();
              break;
            }
            case 34: {
              java.lang.String s = input.readStringRequireUtf8();

              genre_ = s;
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
      return fisher.kafka.streams.proto.ParsedMovie.internal_static_fisher_kafka_streams_proto_Movie_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return fisher.kafka.streams.proto.ParsedMovie.internal_static_fisher_kafka_streams_proto_Movie_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              fisher.kafka.streams.proto.ParsedMovie.Movie.class, fisher.kafka.streams.proto.ParsedMovie.Movie.Builder.class);
    }

    public static final int ID_FIELD_NUMBER = 1;
    private long id_;
    /**
     * <code>optional uint64 id = 1;</code>
     */
    public long getId() {
      return id_;
    }

    public static final int TITLE_FIELD_NUMBER = 2;
    private volatile java.lang.Object title_;
    /**
     * <code>optional string title = 2;</code>
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
     * <code>optional string title = 2;</code>
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

    public static final int RELEASE_YEAR_FIELD_NUMBER = 3;
    private int releaseYear_;
    /**
     * <code>optional uint32 release_year = 3;</code>
     */
    public int getReleaseYear() {
      return releaseYear_;
    }

    public static final int GENRE_FIELD_NUMBER = 4;
    private volatile java.lang.Object genre_;
    /**
     * <code>optional string genre = 4;</code>
     */
    public java.lang.String getGenre() {
      java.lang.Object ref = genre_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        genre_ = s;
        return s;
      }
    }
    /**
     * <code>optional string genre = 4;</code>
     */
    public com.google.protobuf.ByteString
        getGenreBytes() {
      java.lang.Object ref = genre_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        genre_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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
      if (id_ != 0L) {
        output.writeUInt64(1, id_);
      }
      if (!getTitleBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, title_);
      }
      if (releaseYear_ != 0) {
        output.writeUInt32(3, releaseYear_);
      }
      if (!getGenreBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, genre_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (id_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(1, id_);
      }
      if (!getTitleBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, title_);
      }
      if (releaseYear_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(3, releaseYear_);
      }
      if (!getGenreBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, genre_);
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
      if (!(obj instanceof fisher.kafka.streams.proto.ParsedMovie.Movie)) {
        return super.equals(obj);
      }
      fisher.kafka.streams.proto.ParsedMovie.Movie other = (fisher.kafka.streams.proto.ParsedMovie.Movie) obj;

      boolean result = true;
      result = result && (getId()
          == other.getId());
      result = result && getTitle()
          .equals(other.getTitle());
      result = result && (getReleaseYear()
          == other.getReleaseYear());
      result = result && getGenre()
          .equals(other.getGenre());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getId());
      hash = (37 * hash) + TITLE_FIELD_NUMBER;
      hash = (53 * hash) + getTitle().hashCode();
      hash = (37 * hash) + RELEASE_YEAR_FIELD_NUMBER;
      hash = (53 * hash) + getReleaseYear();
      hash = (37 * hash) + GENRE_FIELD_NUMBER;
      hash = (53 * hash) + getGenre().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static fisher.kafka.streams.proto.ParsedMovie.Movie parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static fisher.kafka.streams.proto.ParsedMovie.Movie parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static fisher.kafka.streams.proto.ParsedMovie.Movie parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static fisher.kafka.streams.proto.ParsedMovie.Movie parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static fisher.kafka.streams.proto.ParsedMovie.Movie parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static fisher.kafka.streams.proto.ParsedMovie.Movie parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static fisher.kafka.streams.proto.ParsedMovie.Movie parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static fisher.kafka.streams.proto.ParsedMovie.Movie parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static fisher.kafka.streams.proto.ParsedMovie.Movie parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static fisher.kafka.streams.proto.ParsedMovie.Movie parseFrom(
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
    public static Builder newBuilder(fisher.kafka.streams.proto.ParsedMovie.Movie prototype) {
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
     * Protobuf type {@code fisher.kafka.streams.proto.Movie}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:fisher.kafka.streams.proto.Movie)
        fisher.kafka.streams.proto.ParsedMovie.MovieOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return fisher.kafka.streams.proto.ParsedMovie.internal_static_fisher_kafka_streams_proto_Movie_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return fisher.kafka.streams.proto.ParsedMovie.internal_static_fisher_kafka_streams_proto_Movie_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                fisher.kafka.streams.proto.ParsedMovie.Movie.class, fisher.kafka.streams.proto.ParsedMovie.Movie.Builder.class);
      }

      // Construct using fisher.kafka.streams.proto.ParsedMovie.Movie.newBuilder()
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
        id_ = 0L;

        title_ = "";

        releaseYear_ = 0;

        genre_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return fisher.kafka.streams.proto.ParsedMovie.internal_static_fisher_kafka_streams_proto_Movie_descriptor;
      }

      public fisher.kafka.streams.proto.ParsedMovie.Movie getDefaultInstanceForType() {
        return fisher.kafka.streams.proto.ParsedMovie.Movie.getDefaultInstance();
      }

      public fisher.kafka.streams.proto.ParsedMovie.Movie build() {
        fisher.kafka.streams.proto.ParsedMovie.Movie result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public fisher.kafka.streams.proto.ParsedMovie.Movie buildPartial() {
        fisher.kafka.streams.proto.ParsedMovie.Movie result = new fisher.kafka.streams.proto.ParsedMovie.Movie(this);
        result.id_ = id_;
        result.title_ = title_;
        result.releaseYear_ = releaseYear_;
        result.genre_ = genre_;
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
        if (other instanceof fisher.kafka.streams.proto.ParsedMovie.Movie) {
          return mergeFrom((fisher.kafka.streams.proto.ParsedMovie.Movie)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(fisher.kafka.streams.proto.ParsedMovie.Movie other) {
        if (other == fisher.kafka.streams.proto.ParsedMovie.Movie.getDefaultInstance()) return this;
        if (other.getId() != 0L) {
          setId(other.getId());
        }
        if (!other.getTitle().isEmpty()) {
          title_ = other.title_;
          onChanged();
        }
        if (other.getReleaseYear() != 0) {
          setReleaseYear(other.getReleaseYear());
        }
        if (!other.getGenre().isEmpty()) {
          genre_ = other.genre_;
          onChanged();
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
        fisher.kafka.streams.proto.ParsedMovie.Movie parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (fisher.kafka.streams.proto.ParsedMovie.Movie) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long id_ ;
      /**
       * <code>optional uint64 id = 1;</code>
       */
      public long getId() {
        return id_;
      }
      /**
       * <code>optional uint64 id = 1;</code>
       */
      public Builder setId(long value) {
        
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional uint64 id = 1;</code>
       */
      public Builder clearId() {
        
        id_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object title_ = "";
      /**
       * <code>optional string title = 2;</code>
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
       * <code>optional string title = 2;</code>
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
       * <code>optional string title = 2;</code>
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
       * <code>optional string title = 2;</code>
       */
      public Builder clearTitle() {
        
        title_ = getDefaultInstance().getTitle();
        onChanged();
        return this;
      }
      /**
       * <code>optional string title = 2;</code>
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

      private int releaseYear_ ;
      /**
       * <code>optional uint32 release_year = 3;</code>
       */
      public int getReleaseYear() {
        return releaseYear_;
      }
      /**
       * <code>optional uint32 release_year = 3;</code>
       */
      public Builder setReleaseYear(int value) {
        
        releaseYear_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional uint32 release_year = 3;</code>
       */
      public Builder clearReleaseYear() {
        
        releaseYear_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object genre_ = "";
      /**
       * <code>optional string genre = 4;</code>
       */
      public java.lang.String getGenre() {
        java.lang.Object ref = genre_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          genre_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string genre = 4;</code>
       */
      public com.google.protobuf.ByteString
          getGenreBytes() {
        java.lang.Object ref = genre_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          genre_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string genre = 4;</code>
       */
      public Builder setGenre(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        genre_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string genre = 4;</code>
       */
      public Builder clearGenre() {
        
        genre_ = getDefaultInstance().getGenre();
        onChanged();
        return this;
      }
      /**
       * <code>optional string genre = 4;</code>
       */
      public Builder setGenreBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        genre_ = value;
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


      // @@protoc_insertion_point(builder_scope:fisher.kafka.streams.proto.Movie)
    }

    // @@protoc_insertion_point(class_scope:fisher.kafka.streams.proto.Movie)
    private static final fisher.kafka.streams.proto.ParsedMovie.Movie DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new fisher.kafka.streams.proto.ParsedMovie.Movie();
    }

    public static fisher.kafka.streams.proto.ParsedMovie.Movie getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Movie>
        PARSER = new com.google.protobuf.AbstractParser<Movie>() {
      public Movie parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Movie(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Movie> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Movie> getParserForType() {
      return PARSER;
    }

    public fisher.kafka.streams.proto.ParsedMovie.Movie getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_fisher_kafka_streams_proto_Movie_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_fisher_kafka_streams_proto_Movie_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022parsed-movie.proto\022\032fisher.kafka.strea" +
      "ms.proto\"G\n\005Movie\022\n\n\002id\030\001 \001(\004\022\r\n\005title\030\002" +
      " \001(\t\022\024\n\014release_year\030\003 \001(\r\022\r\n\005genre\030\004 \001(" +
      "\tb\006proto3"
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
    internal_static_fisher_kafka_streams_proto_Movie_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_fisher_kafka_streams_proto_Movie_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_fisher_kafka_streams_proto_Movie_descriptor,
        new java.lang.String[] { "Id", "Title", "ReleaseYear", "Genre", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
