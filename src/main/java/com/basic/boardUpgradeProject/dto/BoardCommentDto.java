package com.basic.boardUpgradeProject.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardCommentDto {
    private String comment;
    private Long boardId;
}
