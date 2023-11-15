package com.example.webfluxStudy.mapper;

import com.example.webfluxStudy.dto.BoardDtoMongoDB;
import com.example.webfluxStudy.dto.BoardDtoMongoDB;
import com.example.webfluxStudy.entity.BoardMongoDB;
import com.example.webfluxStudy.entity.BoardMongoDB;

public class BoardMapperMongoDB {

    public static BoardDtoMongoDB.response toDto(BoardMongoDB board) {
        return new BoardDtoMongoDB.response(
                board.getId(),
                board.getTitle(),
                board.getBody(),
                board.getCreatedAt(),
                board.getUpdatedAt()
        );
    }

    public static BoardMongoDB toEntitySave(BoardDtoMongoDB.save boardDto) {
        return new BoardMongoDB(
                null,
                boardDto.getTitle(),
                boardDto.getBody()
        );
    }
    
}
