package com.example.webfluxStudy.repository;

import com.example.webfluxStudy.entity.BoardMariaDB;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepositoryMariaDB extends R2dbcRepository<BoardMariaDB, String> {
}
