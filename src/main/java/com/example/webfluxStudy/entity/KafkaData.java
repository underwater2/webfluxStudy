// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: kafkamessage.proto

// Protobuf Java Version: 3.25.1
package com.example.webfluxStudy.entity;

public final class KafkaData {
  private KafkaData() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_webfluxStudy_entity_FruitMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_webfluxStudy_entity_FruitMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022kafkamessage.proto\022\037com.example.webflu" +
      "xStudy.entity\"P\n\014FruitMessage\022\026\n\002id\030\001 \001(" +
      "\t:\ndefault id\022(\n\007message\030\002 \001(\t:\027this is " +
      "default messageB.\n\037com.example.webfluxSt" +
      "udy.entityB\tKafkaDataP\001"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_example_webfluxStudy_entity_FruitMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_example_webfluxStudy_entity_FruitMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_webfluxStudy_entity_FruitMessage_descriptor,
        new java.lang.String[] { "Id", "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}