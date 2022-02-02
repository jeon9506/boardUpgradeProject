package com.basic.boardUpgradeProject.repository;

import com.basic.boardUpgradeProject.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("select s from Board s join fetch s.user")
    List<Board> findAllByOrderByModifiedAt();
}
