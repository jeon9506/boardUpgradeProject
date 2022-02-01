package com.basic.boardUpgradeProject.controller;


import com.basic.boardUpgradeProject.dto.SignupRequestDto;
import com.basic.boardUpgradeProject.service.KakaoUserService;
import com.basic.boardUpgradeProject.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    private final UserService userService;
    private final KakaoUserService kakaoUserService;

    @Autowired
    public UserController(UserService userService, KakaoUserService kakaoUserService) {
        this.userService = userService;
        this.kakaoUserService = kakaoUserService;
    }

    // 회원 로그인 페이지
    @GetMapping(value = "/user/login")
    public String login() {
        System.out.println("/user/login get 통과완료!!!");
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping(value = "/user/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping(value = "/user/kakao/callback")
    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
        kakaoUserService.kakaoLogin(code);
        return "redirect:/";
    }
}