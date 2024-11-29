package com._donghh.board.api.comment;

import com._donghh.board._core.dto.ApiResponse;
import com._donghh.board.api.comment.dto.request.CreateComment;
import com._donghh.board.api.comment.dto.request.UpdateComment;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("board/{boardId}/comment")
public class CommentController {

    private final CommentService commentService;

    // 댓글 생성
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createComment(
        @RequestBody @Valid CreateComment createComment,
        @PathVariable Long boardId
    ) {
        commentService.createComment(boardId, createComment);
        return ApiResponse.create();
    }

    // 댓글 수정
    @PutMapping("{commentId}")
    public ResponseEntity<ApiResponse<Void>> updateComment(
        @PathVariable Long boardId,
        @PathVariable Long commentId,
        @RequestBody UpdateComment updateComment
    ) {
        commentService.updateComment(boardId, commentId, updateComment);
        return ApiResponse.ok();
    }

    // 댓글 삭제
    @DeleteMapping("{commentId}")
    public ResponseEntity<ApiResponse<Void>> deleteComment(
        @PathVariable Long boardId,
        @PathVariable Long commentId
    ) {
        commentService.deleteComment(boardId, commentId);
        return ApiResponse.ok();
    }
}
