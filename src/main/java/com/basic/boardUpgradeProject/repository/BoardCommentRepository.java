package com.basic.boardUpgradeProject.repository;

import com.basic.boardUpgradeProject.model.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCommentRepository extends JpaRepository<BoardComment, Long> {

}

