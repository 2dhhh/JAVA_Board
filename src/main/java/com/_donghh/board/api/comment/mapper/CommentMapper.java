package com._donghh.board.api.comment.mapper;

import com._donghh.board.api.comment.dto.request.CreateComment;
import com._donghh.board.repository.board.Board;
import com._donghh.board.repository.board.BoardRepository;
import com._donghh.board.repository.comment.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentMapper {

    private final BoardRepository boardRepository;

    public Comment toEntity(Long boardId, CreateComment createComment) {
        Board board = boardRepository.findById(boardId).orElseThrow();
        return (new Comment(board, createComment.content()));
    }
}
