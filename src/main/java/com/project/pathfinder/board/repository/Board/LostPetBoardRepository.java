package com.project.pathfinder.board.repository.Board;

import com.project.pathfinder.board.entity.Board.LostPetBoardEntity;
import com.project.pathfinder.board.entity.Board.LostPropertyBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface LostPetBoardRepository extends JpaRepository<LostPetBoardEntity, Long> {

    Optional<LostPetBoardEntity> findById(Long id);

    @Query("SELECT b FROM LostPetBoardEntity b ORDER BY b.createDate DESC")
    List<LostPetBoardEntity> findTop4ByOrderByCreateDateDesc();

    @Query("SELECT b FROM LostPetBoardEntity b WHERE " +
            "(:classifiName IS NULL OR b.classifiName = :classifiName) AND " +
            "(:findArea IS NULL OR b.findArea = :findArea) AND " +
            "(:findPlace IS NULL OR b.findPlace = :findPlace) AND " +
            "(:lostDate IS NULL OR b.lostDate = :lostDate) AND " +
            "(:petName IS NULL OR b.petName LIKE %:petName%)")
    List<LostPetBoardEntity> searchBoards(
            @Param("classifiName") String classifiName,
            @Param("findArea") String findArea,
            @Param("findPlace") String findPlace,
            @Param("lostDate") LocalDate lostDate,
            @Param("petName") String petName);
}

