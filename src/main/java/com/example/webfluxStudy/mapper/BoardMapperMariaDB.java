package com.example.webfluxStudy.mapper;

import com.example.webfluxStudy.dto.BoardDto;
import com.example.webfluxStudy.dto.BoardDtoMariaDB;
import com.example.webfluxStudy.entity.BoardMariaDB;

public class BoardMapperMariaDB {

//    public static BoardDtoMariaDB toBoardDto(BoardMariaDB board) {
//        return new BoardDtoMariaDB(
//                board.getId(),
//                board.getTitle(),
//                board.getBody()
//        );
//    }

    public static BoardDtoMariaDB.response toDto(BoardMariaDB board) {
        return new BoardDtoMariaDB.response(
                board.getId(),
                board.getTitle(),
                board.getBody(),
                board.getCreatedAt(),
                board.getUpdatedAt()
        );
    }

    public static BoardMariaDB toEntitySave(BoardDtoMariaDB.save boardDto) {
        return new BoardMariaDB(
                null,
                boardDto.getTitle(),
                boardDto.getBody()
        );
    }
    
}
