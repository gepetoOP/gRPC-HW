// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Questions.proto

package question;

public final class QuestionProto {
  private QuestionProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_QuestionRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_QuestionRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_QuestionReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_QuestionReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017Questions.proto\"\037\n\017QuestionRequest\022\014\n\004" +
      "name\030\001 \001(\t\" \n\rQuestionReply\022\017\n\007message\030\001" +
      " \001(\t2>\n\010Question\0222\n\014CallQuestion\022\020.Quest" +
      "ionRequest\032\016.QuestionReply\"\000B\033\n\010question" +
      "B\rQuestionProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_QuestionRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_QuestionRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_QuestionRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_QuestionReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_QuestionReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_QuestionReply_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
