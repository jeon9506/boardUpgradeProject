package com.basic.boardUpgradeProject.controller.controller;

import com.basic.boardUpgradeProject.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/", "/board"})
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {

        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
//            if (userDetails.getUser().getRole() == UserRoleEnum.ADMIN) {
//                model.addAttribute("admin_role", true);
//            }
            return "index";
        } else {
            return "index";
        }
    }
}