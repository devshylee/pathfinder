package com.project.pathfinder.board.repository;

import com.project.pathfinder.board.entity.AcquirePropertyBoardEntity;
import com.project.pathfinder.board.entity.LostPetBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LostPetBoardRepository extends JpaRepository<LostPetBoardEntity, Long> {

    Optional<LostPetBoardEntity> findById(Long id);
}

