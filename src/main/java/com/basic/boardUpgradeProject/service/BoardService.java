package com.basic.boardUpgradeProject.service;


import com.basic.boardUpgradeProject.dto.BoardDto;
import com.basic.boardUpgradeProject.model.Board;
import com.basic.boardUpgradeProject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class BoardService {

    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final BoardRepository boardRepository;

    // 게시글 저장
//    @Transactional
//    public BoardDto creatBoard(BoardDto boardDto) {
//
////        Board createdBoard = boardDto.toEntity();
////
////        return boardRepository.save(createdBoard).toDto();
//    }

    // 게시글 전체조회
    public List<BoardDto> readBoardList() {
        return boardRepository.findAllByOrderByModifiedAt().stream().map(board -> board.toDto())
                .collect(Collectors.toList());
    }

    // 게시글 한개조회
//    public BoardDto readBoard(Integer board_id) {
//        return boardRepository.findById(board_id).get().toDto();
//    }

    // 게시글 수정
//    @Transactional
//    public Integer update(Integer board_id, BoardDto boardDto) {
//        Board board = boardRepository.findById(board_id).orElseThrow(
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//        );
//        board.update(boardDto);
//
//        return board_id;
//    }
//
//    // 게시글 삭제
//    public Integer deleteBoard(Integer board_id) {
//        boardRepository.deleteById(board_id);
//        return board_id;
//    }
}
