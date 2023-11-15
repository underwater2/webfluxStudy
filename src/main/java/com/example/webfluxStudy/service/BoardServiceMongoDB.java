package com.example.webfluxStudy.service;

import com.example.webfluxStudy.dto.BoardDtoMongoDB;
import org.springframework.data.redis.core.ZSetOperations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BoardServiceMongoDB {

    Mono<BoardDtoMongoDB.response> saveBoard(BoardDtoMongoDB.save boardDto);

    Mono<BoardDtoMongoDB.response> getBoard(String id);

//    getBoardList()

    Mono<BoardDtoMongoDB.response> updateBoard(String id, Mono<BoardDtoMongoDB.save> boardDto);

    Mono<Void> deleteBoard(String memberId);

    Flux<ZSetOperations.TypedTuple<String>> getLatestSeenBoard();

    void setLatestSeenBoard(String id);
    
}
