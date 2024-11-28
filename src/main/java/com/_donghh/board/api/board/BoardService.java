package com._donghh.board.api.board;

import com._donghh.board.api.board.dto.request.CreateBoard;
import com._donghh.board.api.board.dto.request.UpdateBoard;
import com._donghh.board.api.board.dto.response.SelectBoard;
import com._donghh.board.api.board.mapper.BoardMapper;
import com._donghh.board.repository.board.Board;
import com._donghh.board.repository.board.BoardRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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

    // 모든 게시글 조회
    @Transactional
    public List<SelectBoard> getAllBoard() {
        List<Board> boards = boardRepository.findAll();
        List<SelectBoard> selectBoards = boardMapper.toDtoList(boards);
        return selectBoards;
    }

    // 게시글 업데이트
    public void update(Long id, UpdateBoard updateBoard) throws Exception {
        Board board = boardRepository.findById(id).orElseThrow(NotFoundException::new);
        board.update(updateBoard);
        boardRepository.save(board);
    }
}
