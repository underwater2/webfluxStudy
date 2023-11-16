package com.example.webfluxStudy.repository;

import com.example.webfluxStudy.entity.BoardMongoDB;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BoardRepositoryMongoDB extends ReactiveMongoRepository<BoardMongoDB, String> {

    @Query(value="{'title': ?0}")
    Flux<BoardMongoDB> findOrderByTitle(String title, Pageable pageable);

}

