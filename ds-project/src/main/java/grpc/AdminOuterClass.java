// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Admin.proto

package grpc;

public final class AdminOuterClass {
  private AdminOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_Request_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_Request_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_Response_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_Response_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013Admin.proto\022\004grpc\"$\n\007Request\022\013\n\003cid\030\001 " +
      "\001(\t\022\014\n\004data\030\002 \001(\t\"\034\n\010Response\022\020\n\010respons" +
      "e\030\001 \001(\t2\312\001\n\005Admin\022/\n\016insertCustomer\022\r.gr" +
      "pc.Request\032\016.grpc.Response\022/\n\016modifyCust" +
      "omer\022\r.grpc.Request\032\016.grpc.Response\022.\n\rq" +
      "ueryCustomer\022\r.grpc.Request\032\016.grpc.Respo" +
      "nse\022/\n\016deleteCustomer\022\r.grpc.Request\032\016.g" +
      "rpc.ResponseB\002P\001b\006proto3"
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
    internal_static_grpc_Request_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_grpc_Request_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_Request_descriptor,
        new java.lang.String[] { "Cid", "Data", });
    internal_static_grpc_Response_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_grpc_Response_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_Response_descriptor,
        new java.lang.String[] { "Response", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
