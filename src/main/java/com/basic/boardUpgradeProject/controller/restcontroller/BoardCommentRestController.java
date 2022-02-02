package com.basic.boardUpgradeProject.controller.restcontroller;

import com.basic.boardUpgradeProject.dto.BoardCommentDto;
import com.basic.boardUpgradeProject.model.BoardComment;
import com.basic.boardUpgradeProject.model.User;
import com.basic.boardUpgradeProject.security.UserDetailsImpl;
import com.basic.boardUpgradeProject.service.BoardCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardCommentRestController {

    private final BoardCommentService boardCommentService;

    // 댓글 저장
    @PostMapping("api/board/comment")
    public BoardComment createBoard(@RequestBody BoardCommentDto boardCommentDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        System.out.println("댓글 저장!!!");
        User user = userDetails.getUser();
        Long userId = user.getId();
        String username = user.getUsername();

        return boardCommentService.creatBoardComment(boardCommentDto, userId, username);
    }

    // 댓글 전체조회
    @GetMapping("api/board/comment")
    public List<BoardComment> readBoarCommentdList() {
        return boardCommentService.readBoardCommentList();
    }

    // 게시글 수정
    @PatchMapping("api/board/comment/{comment_id}")
    public Long updateBoard(@PathVariable Long comment_id, @RequestBody BoardCommentDto boardDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        boardCommentService.updateBoardComment(comment_id, boardDto);

        return comment_id;
    }

    // 게시글 삭제
    @DeleteMapping("api/board/comment/{comment_id}")
    public Long deleteBoard(@PathVariable Long comment_id) {

        boardCommentService.deleteBoardComment(comment_id);
        return comment_id;
    }
}
