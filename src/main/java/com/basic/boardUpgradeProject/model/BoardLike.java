package com.basic.boardUpgradeProject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class BoardLike {

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // ID가 자동으로 생성 및 증가합니다.
    @Column(name = "BOARD_LIKE_ID")
    private Long board_like_id;

    @OneToOne
    @JoinColumn(name = "BOARD_ID", nullable = false)
    private Board board_id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user_id;
}
