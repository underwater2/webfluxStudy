package com.example.webfluxStudy.entity.protoExample.Inheritance;

import com.example.webfluxStudy.entity.FruitMessage;
import com.example.webfluxStudy.entity.protoExample.Inheritance.Inheritance1.Animal;
import com.example.webfluxStudy.entity.protoExample.Inheritance.Inheritance1.Bird;
import com.example.webfluxStudy.entity.protoExample.Inheritance.Inheritance1.Dog;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Inheritance1Use {

    public static void main(String[] args) {
        // Animal 메시지 생성
        Animal animal = Animal.newBuilder()
            .setName("Charlie")
            .build();

        // Bird 메시지 생성 (Animal을 포함)
        Bird bird = Bird.newBuilder()
            .setAnimal(animal)
            .setCanFly(true)
            .build();

        // Dog 메시지 생성 (Animal을 포함)
        Dog dog = Dog.newBuilder()
            .setAnimal(animal)
            .setBreed("Labrador")
            .build();

        FruitMessage fruitMessage = FruitMessage.newBuilder()
            .setId("blueberry")
            .setMessage("this is a 블루베리~")
            .build();

        // 생성된 메시지 출력
        log.info("animal -> {}", animal);
        log.info("bird -> {}", bird);
        log.info("dog -> {}", dog);
        log.info("fruitMessage -> {}", fruitMessage);
    }
}
