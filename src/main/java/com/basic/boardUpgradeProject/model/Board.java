package com.basic.boardUpgradeProject.model;

import com.basic.boardUpgradeProject.dto.BoardDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Board extends Timestamped {

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // ID가 자동으로 생성 및 증가합니다.
    @Column(name = "BOARD_ID")
    private Long id;

    // nullable: null 허용 여부
    // unique: 중복 허용 여부 (false 일때 중복 허용)
    @Column(name = "BOARD_TITLE", nullable = false)
    private String title;

    @Column(name = "BOARD_CONTENTS", nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @JsonIgnoreProperties({"board"})
    @OneToMany(mappedBy = "board")
    private List<BoardComment> comment;

    public BoardDto toDto() {
        return BoardDto.builder()
                .id(this.id)
                .title(this.title)
                .contents(this.contents)
                .username(this.getUser().getUsername())
                .createAt(this.getCreateAt())
                .modifiedAt(this.getModifiedAt())
                .build();
    }
}
