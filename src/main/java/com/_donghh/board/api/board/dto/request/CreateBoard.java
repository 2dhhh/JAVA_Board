package com._donghh.board.api.board.dto.request;

import com._donghh.board.repository.board.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateBoard {

    private String title;

    private String content;

}
