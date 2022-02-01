package com.basic.boardUpgradeProject.service;


import com.basic.boardUpgradeProject.dto.LoginRequestDto;
import com.basic.boardUpgradeProject.dto.SignupRequestDto;
import com.basic.boardUpgradeProject.model.User;
import com.basic.boardUpgradeProject.model.UserRoleEnum;
import com.basic.boardUpgradeProject.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 회원가입
    public void registerUser(SignupRequestDto requestDto) {
        // 회원 ID 중복 확인
        String username = requestDto.getUsername();
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }

        // 패스워드 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());
        String email = requestDto.getEmail();

        // 사용자 ROLE 확인
        UserRoleEnum role = UserRoleEnum.USER;
        if (requestDto.isAdmin()) {
            if (!requestDto.getAdminToken().equals(ADMIN_TOKEN)) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            role = UserRoleEnum.ADMIN;
        }

        User user = new User(username, password, email, role);
        userRepository.save(user);
    }

    // username 중복여부 chk 메서드
    public void usernameDuplChk(String username) {
        // 회원 ID 중복 확인
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 닉네임 입니다!");
        }
    }

    // login chk 메서드
    public void loginUser(@NotNull LoginRequestDto requestDto) {
        // login 정보 확인
        String username = requestDto.getUsername();
        Optional<User> found = userRepository.findByUsername(username);

        if (!found.isPresent()) {
            throw new IllegalArgumentException("존재하지않는 닉네임입니다!");
        }

//        String password = passwordEncoder.encode(requestDto.getPassword());
        if (!passwordEncoder.matches(requestDto.getPassword(), found.get().getPassword())) {
            throw new IllegalArgumentException("닉네임 또는 패스워드를 확인해주세요!");
        }
    }
}