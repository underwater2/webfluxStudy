package com.example.webfluxStudy.controller;

import com.example.webfluxStudy.dto.BoardDto;
import com.example.webfluxStudy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping
    public Mono<BoardDto> saveBoard(@RequestBody BoardDto boardDto) {
        System.out.println("boardDto = " + boardDto);
        return boardService.saveBoard(boardDto);
    }

    @GetMapping("/{id}")
    public Mono<BoardDto> getBoard(@PathVariable String id){
        return boardService.getBoard(id);
    }

    @PutMapping("/{id}")
    public Mono<BoardDto> updateBoard(@PathVariable String id, @RequestBody Mono<BoardDto> boardDto){
        return boardService.updateBoard(id, boardDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteMember(@PathVariable("id") String id){
        return boardService.deleteBoard(id);
    }

    @GetMapping("/latest-seen-board")
    public Flux<ZSetOperations.TypedTuple<String>> getLatestSeenBoard() {
        return boardService.getLatestSeenBoard();
    }


    /*

    // redis 연결 테스트 코드
    @Autowired
    private ReactiveRedisTemplate<String, String> reactiveRedisTemplate;
//    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/redis-test")
    public void checkRedisConnection() {

        reactiveRedisTemplate.opsForValue()
                .set("test-key3", "test-value3")
                .flatMap(result -> reactiveRedisTemplate.opsForValue().get("test-key3"))
                .doOnNext(value -> System.out.println("Connected to Redis, value retrieved: " + value))
                .onErrorResume(error -> {
                    System.err.println("Error connecting to Redis: " + error.getMessage());
                    return Mono.empty();
                })
                .subscribe();

// 동기
//        try {
//            redisTemplate.opsForValue().set("test-key2", "test-value2");
//            Mono<String> value = redisTemplate.opsForValue().get("test-key2");
//            System.out.println("Connected to Redis, value retrieved: " + value);
//        } catch (Exception e) {
//            System.err.println("Error connecting to Redis: " + e.getMessage());
//        }
    }

     */
}
