package com.basic.boardUpgradeProject.controller.restcontroller;

import com.basic.boardUpgradeProject.dto.BoardDto;
import com.basic.boardUpgradeProject.model.Board;
import com.basic.boardUpgradeProject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardRestController {

    private final BoardService boardService;

    // 게시글 저장
//    @PostMapping("api/board")
//    public BoardDto createBoard(@RequestBody BoardDto requestDto) {
//        System.out.println(requestDto.getBoard_title());
//        System.out.println(requestDto.getUser_name());
//        System.out.println(requestDto.getBoard_contents());
//        System.out.println("게시글 저장 성공!!!");
//        return boardService.creatBoard(requestDto);
//    }

    // 게시글 전체조회
    @GetMapping("api/board")
    public List<BoardDto> readBoardList() {
        System.out.println("게시글 전체조회 성공!!!");

        return boardService.readBoardList();
    }

//    // 게시글 한개조회
//    @GetMapping("api/board/{board_id}")
//    public BoardDto readBoard(@PathVariable Integer board_id) {
//        System.out.println("게시글 한개조회 성공!!!");
//        return boardService.readBoard(board_id);
//    }
//
//    // 게시글 수정
//    @PatchMapping("api/board/{board_id}")
//    public Integer updateBoard(@PathVariable Integer board_id, @RequestBody BoardDto boardDto) {
//        boardService.update(board_id, boardDto);
//        System.out.println("수정완료 : " + board_id);
//        return board_id;
//    }
//
//    // 게시글 삭제
//    @DeleteMapping("api/board/{board_id}")
//    public Integer deleteBoard(@PathVariable Integer board_id) {
//        boardService.deleteBoard(board_id);
//        return board_id;
//    }
}