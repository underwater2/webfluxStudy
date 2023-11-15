package com.example.webfluxStudy.service.impl;

import com.example.webfluxStudy.dto.BoardDtoMariaDB;
import com.example.webfluxStudy.entity.BoardMariaDB;
import com.example.webfluxStudy.mapper.BoardMapperMariaDB;
import com.example.webfluxStudy.repository.BoardRepositoryMariaDB;
import com.example.webfluxStudy.service.BoardServiceMariaDB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class BoardServiceImplMariaDB implements BoardServiceMariaDB {

    @Autowired
    private BoardRepositoryMariaDB boardRepository;

    @Autowired
    private ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    private static final String KEY = "board";


    @Override
    public Mono<BoardDtoMariaDB.response> saveBoard(BoardDtoMariaDB.save boardDto) {
        BoardMariaDB board = BoardMapperMariaDB.toEntitySave(boardDto);
        log.info("보드 -> {}", board);
        Mono<BoardMariaDB> savedBoard = boardRepository.save(board);
        return savedBoard
                .map(BoardMapperMariaDB::toDto);
    }

    @Override
    public Mono<BoardDtoMariaDB.response> getBoard(String id) {
        Mono<BoardMariaDB> foundBoard = boardRepository.findById(id);

//        setLatestSeenBoard(id);
        return foundBoard
                .map(BoardMapperMariaDB::toDto)
                .switchIfEmpty(Mono.empty());
    }

    /*
    @Override
    public Mono<BoardDtoMariaDB.response> updateBoard(String id, Mono<BoardDtoMariaDB> boardDto) {
        return boardRepository.findById(id)
                .zipWith(boardDto)
                .doOnNext(t -> {
                    t.getT1().setTitle(t.getT2().getTitle());
                    t.getT1().setBody(t.getT2().getBody());
                })
                .map(Tuple2::getT1)
                .flatMap(boardRepository::save)
                .map(BoardMapperMariaDB::toDto);
    }

    @Override
    public Mono<Void> deleteBoard(String id) {
        return boardRepository.deleteById(id);
    }


    // ------ redis cache

    public Flux<ZSetOperations.TypedTuple<String>> getLatestSeenBoard() {
        return reactiveRedisTemplate.opsForZSet()
                .reverseRangeWithScores(
                        "latest-seen-boards:" + "username",
                        Range.of(Range.Bound.inclusive((long) 0), Range.Bound.inclusive((long) 9)))
                .doOnNext(tuple -> log.info("tuple = {}", tuple));
    }

    public void setLatestSeenBoard(String id) {

        reactiveRedisTemplate.opsForZSet()
                .add("latest-seen-boards:" + "username",
                        KEY + ":" + id,
                        Double.parseDouble(new SimpleDateFormat("yyyyMMddHHmmss").format(new Timestamp(System.currentTimeMillis()))))
//                .flatMap(result -> reactiveRedisTemplate.opsForValue().get("test-key3"))
//                .doOnNext(value -> log.info("Connected to Redis, value retrieved: {}", value))
                .onErrorResume(error -> {
                    log.error("Error connecting to Redis: {}", error.getMessage());
                    return Mono.empty();
                })
                .subscribe();

    }
    */
}
