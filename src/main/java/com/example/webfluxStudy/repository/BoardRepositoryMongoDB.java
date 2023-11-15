package com.example.webfluxStudy.repository;

import com.example.webfluxStudy.entity.BoardMongoDB;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepositoryMongoDB extends ReactiveCrudRepository<BoardMongoDB, String> {
}

