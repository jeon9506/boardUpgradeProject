package com.basic.boardUpgradeProject.controller.controller;

import com.basic.boardUpgradeProject.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

    // 게시판 상세페이지
    @RequestMapping("/board/{board_id}")
    public String boardDetail(Model model, @PathVariable("board_id") Integer board_id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("board_id", board_id);

        if(userDetails != null){
            model.addAttribute("username", userDetails.getUsername());
        }

        return "boardDetail";
    }

    // 게시판 등록페이지
    @RequestMapping("/board/write")
    public String boardWrite() {
        return "boardWrite";
    }
}
