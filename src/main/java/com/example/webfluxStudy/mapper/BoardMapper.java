package com.example.webfluxStudy.mapper;

import com.example.webfluxStudy.dto.BoardDto;
import com.example.webfluxStudy.entity.BoardMongoDB;

public class BoardMapper {

    public static BoardDto toBoardDto(BoardMongoDB board) {
        return new BoardDto(
                board.getId(),
                board.getTitle(),
                board.getBody()
        );
    }

    public static BoardMongoDB toBoard(BoardDto boardDto) {
        return new BoardMongoDB(
                boardDto.getId(),
                boardDto.getTitle(),
                boardDto.getBody()
        );
    }
    
}
