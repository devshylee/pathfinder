package com.project.pathfinder.board.repository;

import com.project.pathfinder.board.entity.LostPropertyBoardEntity;
import com.project.pathfinder.board.entity.WantedBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WantedBoardRepository extends JpaRepository<WantedBoardEntity, Long> {

    Optional<WantedBoardEntity> findById(Long id);
}


