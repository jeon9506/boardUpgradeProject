package com.basic.boardUpgradeProject.model;

import com.basic.boardUpgradeProject.dto.BoardCommentDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class BoardComment extends Timestamped {

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // ID가 자동으로 생성 및 증가합니다.
    @Column(name = "BOARD_COMMENT_ID")
    private Long commentId;

    @Column(name = "BOARD_COMMENT", nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "BOARD_ID", nullable = false)
    private Board board;

    private Long userId;
    private String username;

    // 빌더 패턴 dto -> entity(생성자)
    @Builder
    public BoardComment(BoardCommentDto boardCommentDto, Board board, Long userId, String username) {
        this.comment = boardCommentDto.getComment();
        this.board = board;
        this.userId = userId;
        this.username = username;
    }

    public void update(BoardCommentDto boardCommentDto) {
        this.comment = boardCommentDto.getComment();
    }
}
