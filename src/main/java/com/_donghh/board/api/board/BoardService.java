package com._donghh.board.api.board;

import com._donghh.board.api.board.dto.request.CreateBoard;
import com._donghh.board.api.board.mapper.BoardMapper;
import com._donghh.board.repository.board.Board;
import com._donghh.board.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    // 게시글 생성
    @Transactional
    public void createBoard(CreateBoard createBoard) {
        Board board = boardMapper.toEntity(createBoard);
        boardRepository.save(board);
    }


}
