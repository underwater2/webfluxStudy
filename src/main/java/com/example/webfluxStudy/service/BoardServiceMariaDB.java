package com.example.webfluxStudy.service;

import com.example.webfluxStudy.dto.BoardDtoMariaDB;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.ZSetOperations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BoardServiceMariaDB {

    Mono<BoardDtoMariaDB.response> saveBoard(BoardDtoMariaDB.save boardDto);

    Mono<BoardDtoMariaDB.response> getBoard(String id);

    Mono<Page<BoardDtoMariaDB.response>> getBoardList(PageRequest pageRequest);

    /*
    Mono<BoardDtoMariaDB.response> updateBoard(String id, Mono<BoardDtoMariaDB> boardDto);

    Mono<Void> deleteBoard(String memberId);

    Flux<ZSetOperations.TypedTuple<String>> getLatestSeenBoard();

    void setLatestSeenBoard(String id);
    */
}
