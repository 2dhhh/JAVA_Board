package com._donghh.board.api.board;

import com._donghh.board._core.dto.ApiResponse;
import com._donghh.board.api.board.dto.request.CreateBoard;
import com._donghh.board.api.board.dto.response.SelectBoard;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<ApiResponse<Void>> createBoard(@RequestBody @Valid CreateBoard createBoard){
        boardService.createBoard(createBoard);
        return ApiResponse.create();
    }

    // 게시글 조회
    @GetMapping
    public ResponseEntity<ApiResponse<List<SelectBoard>>> getAllBoard(){
        List<SelectBoard> selectBoards = boardService.getAllBoard();
        return ApiResponse.of(HttpStatus.OK, selectBoards);
    }

    // 게시글 업데이트

    // 게시글 삭제
}
