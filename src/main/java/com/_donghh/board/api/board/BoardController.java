package com._donghh.board.api.board;

import com._donghh.board._core.dto.ApiResponse;
import com._donghh.board.api.board.dto.request.CreateBoard;
import com._donghh.board.api.board.dto.request.UpdateBoard;
import com._donghh.board.api.board.dto.response.SelectBoard;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    // 게시글 생성
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createBoard(
        @RequestBody @Valid CreateBoard createBoard) {
        boardService.createBoard(createBoard);
        return ApiResponse.create();
    }

    // 게시글 조회
    @GetMapping
    public ResponseEntity<ApiResponse<List<SelectBoard>>> getAllBoard() {
        List<SelectBoard> selectBoards = boardService.getAllBoard();
        return ApiResponse.of(HttpStatus.OK, selectBoards);
    }

    // 게시글 업데이트
    // TODO : 추후에 예외 핸들링
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateBoard(
                                            @PathVariable Long id,
                                            @RequestBody UpdateBoard updateBoard) throws Exception {
        boardService.update(id, updateBoard);
        return ApiResponse.ok();
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteBoard(@PathVariable Long id)
        throws NotFoundException {
        boardService.deleteBoard(id);
        return ApiResponse.ok();
    }

}
