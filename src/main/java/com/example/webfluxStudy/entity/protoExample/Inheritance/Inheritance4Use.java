package com.example.webfluxStudy.entity.protoExample.Inheritance;

import com.example.webfluxStudy.entity.protoExample.Inheritance.Inheritance3.Animal;
import com.example.webfluxStudy.entity.protoExample.Inheritance.Inheritance3.Bird;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Inheritance4Use {

    public static void main(String[] args) {

        Animal animal = Animal.newBuilder()
            .setName("Charlie")
            .build();

        // Bird 메시지 생성
        Bird bird1 = Bird.newBuilder()
            .setCanFly(true)
            .setMsg(
                Any.newBuilder()
                    .setTypeUrl(
//                        "type.googleapis.com/animal.Animal") //오류
//                        "type.googleapis.com/animals.Animal") //오류
                        "type.googleapis.com/com.example.webfluxStudy.entity.protoExample.Inheritance.Animal")
                    .setValue(ByteString.copyFrom(animal.toByteArray()))
                    .build()
            )
            .build();

        // 어떤 타입인지 알고 있을 때 -> unpack 사용
        try {
            bird1.getMsg().unpack(Animal.class);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        // 어떤 타입인지 모를 때 -> type_url을 확인하여 메시지 타입을 식별
        try {
            Any msg = bird1.getMsg();
            String typeUrl = msg.getTypeUrl();
            if (typeUrl.equals(
                "type.googleapis.com/com.example.webfluxStudy.entity.protoExample.Inheritance.Animal")) {
                Animal msgValue = Animal.parseFrom(msg.getValue());
            } else if (typeUrl.equals(
                "type.googleapis.com/com.example.webfluxStudy.entity.protoExample.Inheritance.Bird")) {
                Bird msgValue = Bird.parseFrom(msg.getValue());
//                "type.googleapis.com/com.example.webfluxStudy.entity.protoExample.Inheritance.Panda")) {
//                Panda msgValue = Panda.parseFrom(msg.getValue());
            } else {
                // 처리할 수 없는 타입에 대한 로직
            }
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        // Bird 메시지 생성
        Bird bird2 = Bird.newBuilder()
            .setCanFly(true)
            .setMsg(
                Any.pack(animal)
            )
            .build();

//        bird2.getMsg().unpack(Animal.class);

//        Bird birdBase = Bird.newBuilder()
//            .setCanFly(true)
//            .build();
//
//        // Dog 메시지 생성
//        Dog dogBase = Dog.newBuilder()
//            .setBreed("Labrador")
//            .build();
//
//        // Animal 메시지 생성 (Bird 또는 Dog 중 하나를 선택)
//        Animal bird = Animal.newBuilder()
//            .setName("Charlie")
//            .setBird(birdBase) // 또는 setDog(dog)
//            .build();
//
//        Animal dog = Animal.newBuilder()
//            .setName("Charlie")
//            .setDog(dogBase) // 또는 setDog(dog)
//            .build();
//
//        Animal animal = Animal.newBuilder()
//            .setName("Charlie")
//            .build();

        // 생성된 메시지 출력
        log.info("animal -> {}", animal);
        log.info("bird1 -> {}", bird1);
        log.info("bird2 -> {}", bird2);
//        log.info("dog -> {}", dog);
        System.out.println(bird1);
    }
}
