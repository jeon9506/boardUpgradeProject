package com.basic.boardUpgradeProject.controller.restcontroller;

import com.basic.boardUpgradeProject.dto.LoginRequestDto;
import com.basic.boardUpgradeProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class LoginRestController {
    private final UserService userService;

    // 로그인 요청 처리
    @PostMapping("/user/loginChk")
    public Map<String, Object> loginUser(@RequestBody LoginRequestDto requestDto) {
        Map<String, Object> map = new HashMap<>();

        boolean chk = false;
        String msg = "";

        System.out.println("user/login post 통과!!!" + chk);
        try {
            userService.loginUser(requestDto);
            chk = true;
        } catch (Exception e) {
            msg = e.getMessage();
            chk = false;
        }
        System.out.println(chk);
        map.put("chk", chk);
        map.put("msg", msg);

        return map;
    }
}
