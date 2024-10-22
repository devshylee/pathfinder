package com.project.pathfinder.board.repository.Board;

import com.project.pathfinder.board.entity.Board.LostPropertyBoardEntity;
import com.project.pathfinder.board.entity.Board.WantedBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WantedBoardRepository extends JpaRepository<WantedBoardEntity, Long> {

    Optional<WantedBoardEntity> findById(Long id);

    @Query("SELECT b FROM WantedBoardEntity b ORDER BY b.createDate DESC")
    List<WantedBoardEntity> findTop4ByOrderByCreateDateDesc();

    @Query("SELECT b FROM WantedBoardEntity b WHERE " +
            "(:classifiName IS NULL OR b.classifiName = :classifiName) AND " +
            "(:lostArea IS NULL OR b.lostArea = :lostArea) AND " +
            "(:lostPlace IS NULL OR b.lostPlace = :lostPlace) AND " +
            "(:lostDate IS NULL OR b.lostDate = :lostDate) AND " +
            "(:request_cost IS NULL OR b.request_cost = :request_cost) AND " +
            "(:lostPropertyName IS NULL OR b.lostPropertyName LIKE %:lostPropertyName%)")
    List<WantedBoardEntity> searchBoards(
            @Param("classifiName") String classifiName,
            @Param("lostArea") String lostArea,
            @Param("lostPlace") String lostPlace,
            @Param("lostDate") LocalDate lostDate,
            @Param("request_cost") String request_cost,
            @Param("lostPropertyName") String lostPropertyName);
}


