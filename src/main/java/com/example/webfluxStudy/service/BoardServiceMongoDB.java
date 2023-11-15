package com.example.webfluxStudy.service;

import com.example.webfluxStudy.dto.BoardDto;
import org.springframework.data.redis.core.ZSetOperations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BoardServiceMongoDB {

    Mono<BoardDto> saveBoard(BoardDto boardDto);

    Mono<BoardDto> getBoard(String id);

//    getBoardList()

    Mono<BoardDto> updateBoard(String id, Mono<BoardDto> boardDto);

    Mono<Void> deleteBoard(String memberId);

    Flux<ZSetOperations.TypedTuple<String>> getLatestSeenBoard();

    void setLatestSeenBoard(String id);
    
}
