// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: inheritance4.proto

// Protobuf Java Version: 3.25.1
package com.example.webfluxStudy.entity.protoExample.Inheritance;

public final class Inheritance4 {
  private Inheritance4() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_animals_Animal_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_animals_Animal_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_animals_Bird_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_animals_Bird_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_animals_Dog_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_animals_Dog_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022inheritance4.proto\022\007animals\032\031google/pr" +
      "otobuf/any.proto\"\026\n\006Animal\022\014\n\004name\030\001 \001(\t" +
      "\":\n\004Bird\022!\n\003msg\030\001 \001(\0132\024.google.protobuf." +
      "Any\022\017\n\007can_fly\030\002 \001(\010\"7\n\003Dog\022!\n\003msg\030\001 \001(\013" +
      "2\024.google.protobuf.Any\022\r\n\005breed\030\002 \001(\tB<\n" +
      "8com.example.webfluxStudy.entity.protoEx" +
      "ample.InheritanceP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.AnyProto.getDescriptor(),
        });
    internal_static_animals_Animal_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_animals_Animal_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_animals_Animal_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_animals_Bird_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_animals_Bird_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_animals_Bird_descriptor,
        new java.lang.String[] { "Msg", "CanFly", });
    internal_static_animals_Dog_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_animals_Dog_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_animals_Dog_descriptor,
        new java.lang.String[] { "Msg", "Breed", });
    com.google.protobuf.AnyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
