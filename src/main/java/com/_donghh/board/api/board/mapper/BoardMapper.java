package com._donghh.board.api.board.mapper;

import com._donghh.board.api.board.dto.request.CreateBoard;
import com._donghh.board.repository.board.Board;
import org.springframework.stereotype.Component;

@Component
public class BoardMapper {

    public Board toEntity(CreateBoard createBoard){
        return new Board(createBoard.getTitle(), createBoard.getContent());
    }
}
