package com.example.webfluxStudy.entity.protoExample.Inheritance;

import com.example.webfluxStudy.entity.protoExample.Inheritance.Inheritance2.Animal;
import com.example.webfluxStudy.entity.protoExample.Inheritance.Inheritance2.Bird;
import com.example.webfluxStudy.entity.protoExample.Inheritance.Inheritance2.Dog;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Inheritance2Use {

    public static void main(String[] args) {
        // Bird 메시지 생성
        Bird birdBase = Bird.newBuilder()
            .setCanFly(true)
            .build();

        // Dog 메시지 생성
        Dog dogBase = Dog.newBuilder()
            .setBreed("Labrador")
            .build();

        // Animal 메시지 생성 (Bird 또는 Dog 중 하나를 선택)
        Animal bird = Animal.newBuilder()
            .setName("Charlie")
            .setBird(birdBase) // 또는 setDog(dog)
            .build();

        Animal dog = Animal.newBuilder()
            .setName("Charlie")
            .setDog(dogBase) // 또는 setDog(dog)
            .build();

        Animal animal = Animal.newBuilder()
            .setName("Charlie")
            .build();

        // 생성된 메시지 출력
        log.info("animal -> {}", animal);
        log.info("bird -> {}", bird);
        log.info("dog -> {}", dog);
    }
}
