package com.example.webfluxStudy.controller;

import com.example.webfluxStudy.dto.BoardDto;
import com.example.webfluxStudy.exception.ApiResponse;
import com.example.webfluxStudy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping
    public Mono<ResponseEntity<ApiResponse<BoardDto>>> saveBoard(@RequestBody BoardDto boardDto) {
//        HttpHeaders header = new HttpHeaders();
//        header.add("desc", "test header");
        return boardService.saveBoard(boardDto)
                .map(dto -> ResponseEntity
                        .status(HttpStatus.CREATED)
//                        .headers(header)
                        .header("desc", "test header", "test header2")
                        .body(ApiResponse.<BoardDto>builder()
                                .code(201)
                                .message("test message")
                                .data(dto)
                                .build()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ApiResponse<BoardDto>>> getBoard(@PathVariable String id){
        return boardService.getBoard(id)
                .map(dto -> ResponseEntity
                        .ok()
                        .header("desc", "test header", "test header2")
                        .body(ApiResponse.<BoardDto>builder()
                                .code(200)
                                .message("test message")
                                .data(dto)
                                .build()));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<ApiResponse<BoardDto>>> updateBoard(@PathVariable String id, @RequestBody Mono<BoardDto> boardDto){
        return boardService.updateBoard(id, boardDto)
                .map(dto -> ResponseEntity
                        .ok()
                        .header("desc", "test header", "test header2")
                        .body(ApiResponse.<BoardDto>builder()
                                .code(200)
                                .message("test message")
                                .data(dto)
                                .build()));
    }

    @DeleteMapping("/{id}")
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<ApiResponse<?>>> deleteMember(@PathVariable("id") String id){
        return boardService.deleteBoard(id)
                .map(dto -> ResponseEntity
                        .ok()
                        .header("desc", "test header", "test header2")
                        .body(ApiResponse.builder()
                                .code(200)
                                .message("test message")
                                .data(null)
                                .build()));
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
