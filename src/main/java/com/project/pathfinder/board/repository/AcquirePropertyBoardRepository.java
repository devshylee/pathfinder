package com.project.pathfinder.board.repository;

import com.project.pathfinder.board.entity.AcquirePropertyBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcquirePropertyBoardRepository extends JpaRepository<AcquirePropertyBoardEntity, Long> {

    Optional<AcquirePropertyBoardEntity> findById(Long id);
}
