package com.example.webfluxStudy.service;

import com.example.webfluxStudy.dto.BoardDto;
import com.example.webfluxStudy.entity.Board;
import com.example.webfluxStudy.mapper.BoardMapper;
import com.example.webfluxStudy.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;
    
    @Autowired
    private ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    private static final String KEY = "board";


    @Override
    public Mono<BoardDto> saveBoard(BoardDto boardDto) {
        Board board = BoardMapper.toBoard(boardDto);
        Mono<Board> savedBoard = boardRepository.save(board);
        return savedBoard
                .map(BoardMapper::toBoardDto);
    }

    @Override
    public Mono<BoardDto> getBoard(String id) {
        Mono<Board> foundBoard = boardRepository.findById(id);

        setLatestSeenBoard(id);
        return foundBoard
                .map(BoardMapper::toBoardDto)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<BoardDto> updateBoard(String id, Mono<BoardDto> boardDto) {
        return boardRepository.findById(id)
                .zipWith(boardDto)
                .doOnNext(t -> {
                    t.getT1().setTitle(t.getT2().getTitle());
                    t.getT1().setBody(t.getT2().getBody());
                })
                .map(Tuple2::getT1)
                .flatMap(boardRepository::save)
                .map(BoardMapper::toBoardDto);
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
}
