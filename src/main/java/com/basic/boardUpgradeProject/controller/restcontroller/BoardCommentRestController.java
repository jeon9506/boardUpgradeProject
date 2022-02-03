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
    @GetMapping("api/board/comment/{board_id}")
    public List<BoardComment> readBoarCommentdList(@PathVariable Long board_id) {
        List<BoardComment> boardComment = boardCommentService.readBoardCommentList(board_id);

        return boardComment;
    }

    // 댓글 수정
    @PatchMapping("api/board/comment/{comment_id}")
    public Long updateBoardComment(@PathVariable Long comment_id, @RequestBody BoardCommentDto boardCommentDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        boardCommentDto.setUserId(userDetails.getUser().getId());
        boardCommentService.updateBoardComment(comment_id, boardCommentDto);

        return comment_id;
    }

    // 댓글 삭제
    @DeleteMapping("api/board/comment/{comment_id}")
    public Long deleteBoardComment(@PathVariable Long comment_id) {

        boardCommentService.deleteBoardComment(comment_id);
        return comment_id;
    }
}
