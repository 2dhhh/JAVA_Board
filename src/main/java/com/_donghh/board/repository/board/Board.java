package com._donghh.board.repository.board;

import com._donghh.board.api.board.dto.request.CreateBoard;
import com._donghh.board.api.board.dto.request.UpdateBoard;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String title;

    @Lob @Column(nullable = false)
    String content;

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(UpdateBoard updateBoard){
        this.title = updateBoard.title();
        this.content = updateBoard.content();
    }
}
