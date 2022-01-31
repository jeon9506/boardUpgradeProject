package com.basic.boardUpgradeProject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class User {

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // ID가 자동으로 생성 및 증가합니다.
    @Column(name = "USER_ID")
    private Long id;

    // nullable: null 허용 여부
    // unique: 중복 허용 여부 (false 일때 중복 허용)
    @Column(name = "USER_NAME", nullable = false, unique = true)
    private String username;

    @Column(name = "USER_PASSWORD", nullable = false)
    private String password;

    @Column(name = "USER_EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "USER_ROLE", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    @Column(name = "USER_KAKAO_ID", unique = true)
    private Long kakaoId;

    public User(String username, String password, String email, UserRoleEnum role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.kakaoId = null;
    }

    public User(String username, String password, String email, UserRoleEnum role, Long kakaoId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.kakaoId = kakaoId;
    }
}