package com.example.webfluxStudy.controller;

import com.example.webfluxStudy.dto.BoardDtoMongoDB;
import com.example.webfluxStudy.dto.BoardDtoMariaDB;
import com.example.webfluxStudy.exception.ApiResponse;
import com.example.webfluxStudy.mapper.BoardMapperMariaDB;
import com.example.webfluxStudy.mapper.BoardMapperMongoDB;
import com.example.webfluxStudy.service.BoardServiceMariaDB;
import com.example.webfluxStudy.service.BoardServiceMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/v1/board")
public class BoardController {

    @Autowired
    private BoardServiceMongoDB boardService;

    @Autowired
    private BoardServiceMariaDB boardServiceMariaDB;


    @PostMapping("/item")
    public Mono<ResponseEntity<ApiResponse<BoardDtoMongoDB.response>>> saveBoard(@RequestBody BoardDtoMongoDB.save boardDto) {
//        헤더 여러 개 한꺼번에 추가
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "test header");
        return boardService.saveBoard(boardDto)
                .map(dto -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .headers(header)
                        .body(ApiResponse.<BoardDtoMongoDB.response>builder()
                                .code(201)
                                .message("test message")
                                .data(dto)
                                .build()));
    }

    @GetMapping("/item/{id}")
    public Mono<ResponseEntity<ApiResponse<BoardDtoMongoDB.response>>> getBoard(@PathVariable String id){
        return boardService.getBoard(id)
                .map(dto -> ResponseEntity
                        .ok()
                        .header("desc", "test header", "test header2")
                        .body(ApiResponse.<BoardDtoMongoDB.response>builder()
                                .code(200)
                                .message("test message")
                                .data(dto)
                                .build()));
    }

    @GetMapping("/list/{page}")
    public Mono<ResponseEntity<ApiResponse<Page<BoardDtoMongoDB.response>>>> getBoardList(@RequestParam String title, @PathVariable int page, @RequestParam int size) {
        return boardService.getBoardList(title, PageRequest.of(page, size))
                .map(dto -> ResponseEntity
                        .ok()
                        .header("desc", "test header", "test header2")
                        .body(ApiResponse.<Page<BoardDtoMongoDB.response>>builder()
                                .code(200)
                                .message("test message")
                                .data(dto)
                                .build()));
    }

    @PutMapping("/item/{id}")
    public Mono<ResponseEntity<ApiResponse<BoardDtoMongoDB.response>>> updateBoard(@PathVariable String id, @RequestBody Mono<BoardDtoMongoDB.save> boardDto){
        return boardService.updateBoard(id, boardDto)
                .map(dto -> ResponseEntity
                        .ok()
                        .header("desc", "test header", "test header2")
                        .body(ApiResponse.<BoardDtoMongoDB.response>builder()
                                .code(200)
                                .message("test message")
                                .data(dto)
                                .build()));
    }

    @PatchMapping("/item/title/{id}")
    public Mono<ResponseEntity<ApiResponse<BoardDtoMongoDB.response>>> updateBoardTitle(@PathVariable String id, @RequestParam String title){
        return boardService.updateBoardTitle(id, title)
                .map(dto -> ResponseEntity
                        .ok()
                        .header("desc", "test header", "test header2")
                        .body(ApiResponse.<BoardDtoMongoDB.response>builder()
                                .code(200)
                                .message("test message")
                                .data(dto)
                                .build()));
    }

    @DeleteMapping("/item/{id}")
    public Mono<ResponseEntity<ApiResponse<?>>> deleteMember(@PathVariable("id") String id){
        return boardService.deleteBoard(id)
                .thenReturn(ResponseEntity
                        .ok()
                        .header("desc", "test header", "test header2")
                        .body(ApiResponse.builder()
                                .code(200)
                                .message("test message")
                                .data(null)
                                .build()));
    }


//    data 잘못나오는 코드
//    @GetMapping("/latest-seen")
//    public ResponseEntity<ApiResponse<Flux<ZSetOperations.TypedTuple<String>>>> getLatestSeenBoard() {
//        return ResponseEntity
//                .ok()
//                .header("desc", "test header", "test header2")
//                .body(ApiResponse.<Flux<ZSetOperations.TypedTuple<String>>>builder()
//                        .code(200)
//                        .message("test messagezzzzz")
//                        .data(boardService.getLatestSeenBoard())
//                        .build());
//    }

//    xxxxxx
//    @GetMapping("/latest-seen")
//    public ResponseEntity<ApiResponse<Mono<List<ZSetOperations.TypedTuple<String>>>>> getLatestSeenBoard() {
//        return ResponseEntity
//                .ok()
//                .header("desc", "test header", "test header2")
//                .body(ApiResponse.<Mono<List<ZSetOperations.TypedTuple<String>>>>builder()
//                        .code(200)
//                        .message("test messagezzzzz")
//                        .data(boardService.getLatestSeenBoard().collectList())
//                        .build());
//    }

//    잘 동작하는 코드
    @GetMapping("/latest-seen")
    public ResponseEntity<Flux<ZSetOperations.TypedTuple<String>>> getLatestSeenBoard() {
        return ResponseEntity
                .ok()
                .header("desc", "test header", "test header2")
                .body(boardService.getLatestSeenBoard());
    }

    //---------------------- MariaDB 관련
    @PostMapping("/mariadb/item")
    public Mono<ResponseEntity<ApiResponse<BoardDtoMariaDB.response>>> saveBoardMariaDB(@RequestBody BoardDtoMariaDB.save boardDto) {
        return boardServiceMariaDB.saveBoard(boardDto)
                .map(dto -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .header("desc", "test header", "test header2")
                        .body(ApiResponse.<BoardDtoMariaDB.response>builder()
                                .code(201)
                                .message("test message / MariaDB")
                                .data(dto)
                                .build()));
    }

    @GetMapping("/mariadb/item/{id}")
    public Mono<ResponseEntity<ApiResponse<BoardDtoMariaDB.response>>> getBoardMariaDB(@PathVariable String id){
        return boardServiceMariaDB.getBoard(id)
                .map(dto -> ResponseEntity
                        .ok()
                        .header("desc", "test header", "test header2")
                        .body(ApiResponse.<BoardDtoMariaDB.response>builder()
                                .code(200)
                                .message("test message / MariaDB")
                                .data(dto)
                                .build()));
    }

    @GetMapping("/mariadb/list/{page}")
    public Mono<ResponseEntity<ApiResponse<Page<BoardDtoMariaDB.response>>>> getBoardListMariaDB(@PathVariable int page, @RequestParam int size) {
        return boardServiceMariaDB.getBoardList(PageRequest.of(page, size))
                .map(dto -> ResponseEntity
                        .ok()
                        .header("desc", "test header", "test header2")
                        .body(ApiResponse.<Page<BoardDtoMariaDB.response>>builder()
                                .code(200)
                                .message("test message")
                                .data(dto)
                                .build()));
    }


    //---------------------- redis 연결 테스트 코드

    /*
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
