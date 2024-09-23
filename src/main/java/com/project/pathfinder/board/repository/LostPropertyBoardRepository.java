package com.project.pathfinder.board.repository;

import com.project.pathfinder.board.entity.LostPropertyBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LostPropertyBoardRepository extends JpaRepository<LostPropertyBoardEntity, Long> {

    Optional<LostPropertyBoardEntity> findById(Long id);
}
