package com.basic.boardUpgradeProject.repository;

import com.basic.boardUpgradeProject.model.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardCommentRepository extends JpaRepository<BoardComment, Long> {
    @Query("select s from BoardComment s order by s.modifiedAt desc ")
    List<BoardComment> findAllByOrderByModifiedAtDesc();
}

