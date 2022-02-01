package com.basic.boardUpgradeProject.controller;

import com.basic.boardUpgradeProject.dto.SignupRequestDto;
import com.basic.boardUpgradeProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class SignupRestController {

    private final UserService userService;

    // 닉네임 중복 chk 메서드
    @PostMapping("user/usernameDuplChk/{username}")
    public Map<String, Object> usernameDuplChk(@PathVariable String username) {
        Map<String, Object> map = new HashMap<>();

        boolean chk = false;
        String msg = "";

        System.out.println("user/usernameDuplChk post 통과!!!" + chk);
        try {
            userService.usernameDuplChk(username);
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

    // 회원 가입 요청 처리
    @PostMapping("user/signup")
    public Map<String, Object> registerUser(@RequestBody SignupRequestDto requestDto) {
        Map<String, Object> map = new HashMap<>();

        boolean chk = false;
        String msg = "";

        System.out.println("api/user/signup post 통과!!!" + chk);
        try {
            userService.registerUser(requestDto);
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