package com.example.webfluxStudy.service;

import com.example.webfluxStudy.dto.BoardDtoMariaDB;
import com.example.webfluxStudy.dto.BoardDtoMongoDB;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BoardServiceMongoDB {

    Mono<BoardDtoMongoDB.response> saveBoard(BoardDtoMongoDB.save boardDto);

    Mono<BoardDtoMongoDB.response> getBoard(String id);

    Mono<Page<BoardDtoMongoDB.response>> getBoardList(String title, PageRequest pageRequest);

    Mono<BoardDtoMongoDB.response> updateBoard(String id, Mono<BoardDtoMongoDB.save> boardDto);

    Mono<BoardDtoMongoDB.response> updateBoardTitle(String id, String title);

    Mono<Void> deleteBoard(String memberId);

    Flux<ZSetOperations.TypedTuple<String>> getLatestSeenBoard();

    void setLatestSeenBoard(String id);
    
}
