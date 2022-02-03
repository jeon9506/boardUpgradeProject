package com.basic.boardUpgradeProject.service;

import com.basic.boardUpgradeProject.dto.BoardCommentDto;
import com.basic.boardUpgradeProject.model.Board;
import com.basic.boardUpgradeProject.model.BoardComment;
import com.basic.boardUpgradeProject.repository.BoardCommentRepository;
import com.basic.boardUpgradeProject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class BoardCommentService {

    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final BoardRepository boardRepository;
    private final BoardCommentRepository boardCommentRepository;

    // 댓글 등록 서비스
    @Transactional
    public BoardComment creatBoardComment(BoardCommentDto boardCommentDto, Long userId, String username) {

        Long boardId = boardCommentDto.getBoardId();
        Board board = boardRepository.findById(boardId).orElseThrow(
                () -> new IllegalArgumentException("게시판이 존재하지 않습니다.")
        );

        BoardComment createdBoardComment = new BoardComment(boardCommentDto, board, userId, username);

        return boardCommentRepository.save(createdBoardComment); // boardComment Entity -> boardCommentDto 변환
    }

    // 댓글 전체조회 서비스
    public List<BoardComment> readBoardCommentList() {
        return boardCommentRepository.findAllByOrderByModifiedAtDesc();
    }

    // 댓글 수정 서비스
    @Transactional
    public Long updateBoardComment(Long comment_id, BoardCommentDto boardCommentDto) {
        BoardComment boardComment = boardCommentRepository.findById(comment_id).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다.")
        );
        boardComment.update(boardCommentDto);

        return comment_id;
    }

    // 댓글 삭제 서비스
    public Long deleteBoardComment(Long comment_id) {
        boardCommentRepository.deleteById(comment_id);
        return comment_id;
    }
}
