package com._donghh.board.api.board.mapper;

import com._donghh.board.api.board.dto.request.CreateBoard;
import com._donghh.board.api.board.dto.response.SelectBoard;
import com._donghh.board.repository.board.Board;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class BoardMapper {

    public Board toEntity(CreateBoard createBoard){
        return new Board(createBoard.getTitle(), createBoard.getContent());
    }

    public List<SelectBoard> toDtoList(List<Board> boardList) {
        List<SelectBoard> lists = new ArrayList<SelectBoard>();
        for (Board board : boardList) {
            SelectBoard selectBoard = new SelectBoard(board.getTitle(), board.getContent());
            lists.add(selectBoard);
        }
        return lists;
    }
}
