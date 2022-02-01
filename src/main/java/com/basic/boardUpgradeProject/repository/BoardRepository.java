package com.basic.boardUpgradeProject.repository;

import com.basic.boardUpgradeProject.dto.BoardDto;
import com.basic.boardUpgradeProject.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByModifiedAt();
}
