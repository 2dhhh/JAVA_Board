package com._donghh.board.api.comment;

import com._donghh.board._core.dto.ApiResponse;
import com._donghh.board.api.comment.dto.request.CreateComment;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    ) throws NotFoundException {
        commentService.createComment(boardId, createComment);
        return ApiResponse.create();
    }

    // 댓글 수정



    // 댓글 삭제
}
