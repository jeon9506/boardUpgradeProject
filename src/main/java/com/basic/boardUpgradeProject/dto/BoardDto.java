package com.basic.boardUpgradeProject.dto;

import com.basic.boardUpgradeProject.model.Board;
import com.basic.boardUpgradeProject.model.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String title;
    private String contents;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
    private User user;

    // dto -> entity(생성자)
//    public Board toEntity() {
//        return Board.builder()
//                .user(user)
//                .build();
//    }
}
