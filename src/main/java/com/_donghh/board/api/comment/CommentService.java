package com._donghh.board.api.comment;

import com._donghh.board.api.comment.dto.request.CreateComment;
import com._donghh.board.api.comment.dto.request.UpdateComment;
import com._donghh.board.api.comment.mapper.CommentMapper;
import com._donghh.board.repository.comment.Comment;
import com._donghh.board.repository.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    // 댓글 생성
    @Transactional
    public void createComment(Long boardId, CreateComment createComment) {
        Comment comment = commentMapper.toEntity(boardId, createComment);
        commentRepository.save(comment);
    }

    // 댓글 수정
    public void updateComment(Long boardId, Long commentId, UpdateComment updateComment) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        comment.update(updateComment);
        commentRepository.save(comment);
    }
}
