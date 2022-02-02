package com.basic.boardUpgradeProject.controller.restcontroller;

import com.basic.boardUpgradeProject.dto.BoardDto;
import com.basic.boardUpgradeProject.model.Board;
import com.basic.boardUpgradeProject.model.User;
import com.basic.boardUpgradeProject.security.UserDetailsImpl;
import com.basic.boardUpgradeProject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BoardRestController {

    private final BoardService boardService;

    // 게시글 저장
    @PostMapping("api/board")
    public BoardDto createBoard(@RequestBody BoardDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();

        return boardService.creatBoard(requestDto, user);
    }

    // 게시글 전체조회
    @GetMapping("api/board")
    public List<Board> readBoardList() {
        return boardService.readBoardList();
    }

    // 게시글 한개조회
    @GetMapping("api/board/{board_id}")
    public Optional<Board> readBoard(@PathVariable Long board_id) {
        return boardService.readBoard(board_id);
    }

    // 게시글 수정
    @PatchMapping("api/board/{board_id}")
    public Long updateBoard(@PathVariable Long board_id, @RequestBody BoardDto boardDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        boardService.update(board_id, boardDto);

        return board_id;
    }

    // 게시글 삭제
    @DeleteMapping("api/board/{board_id}")
    public Long deleteBoard(@PathVariable Long board_id) {

        boardService.deleteBoard(board_id);
        return board_id;
    }
}