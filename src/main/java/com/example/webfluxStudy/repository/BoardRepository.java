package com.example.webfluxStudy.repository;

import com.example.webfluxStudy.entity.Board;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends ReactiveCrudRepository<Board, String> {
}

