package com.example.webfluxStudy.entity.protoExample.Inheritance;

import com.example.webfluxStudy.entity.protoExample.Inheritance.Inheritance3.Animal;
import com.example.webfluxStudy.entity.protoExample.Inheritance.Inheritance3.Bird;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Inheritance3Use {

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
                        "type.googleapis.com/com.example.webfluxStudy.entity.protoExample.Inheritance.Animal")
                    .setValue(ByteString.copyFrom(animal.toByteArray()))
                    .build()
            )
            .build();

        // Bird 메시지 생성
        Bird bird2 = Bird.newBuilder()
            .setCanFly(true)
            .setMsg(
                Any.pack(animal)
            )
            .build();

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
    }
}
