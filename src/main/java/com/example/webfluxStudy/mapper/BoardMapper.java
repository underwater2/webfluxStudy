package com.example.webfluxStudy.mapper;

import com.example.webfluxStudy.dto.BoardDto;
import com.example.webfluxStudy.entity.Board;

public class BoardMapper {

    public static BoardDto toBoardDto(Board board) {
        return new BoardDto(
                board.getId(),
                board.getTitle(),
                board.getBody()
        );
    }

    public static Board toBoard(BoardDto boardDto) {
        return new Board(
                boardDto.getId(),
                boardDto.getTitle(),
                boardDto.getBody()
        );
    }
    
}
