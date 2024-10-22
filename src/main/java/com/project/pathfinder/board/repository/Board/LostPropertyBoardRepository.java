package com.project.pathfinder.board.repository.Board;

import com.project.pathfinder.board.entity.Board.LostPropertyBoardEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface LostPropertyBoardRepository extends JpaRepository<LostPropertyBoardEntity, Long> {

    Optional<LostPropertyBoardEntity> findById(Long id);

    @Query("SELECT b FROM LostPropertyBoardEntity b ORDER BY b.createDate DESC")
    List<LostPropertyBoardEntity> findTop4ByOrderByCreateDateDesc(Pageable pageable);

    @Query("SELECT b FROM LostPropertyBoardEntity b WHERE " +
            "(:classifiName IS NULL OR b.classifiName = :classifiName) AND " +
            "(:lostArea IS NULL OR b.lostArea = :lostArea) AND " +
            "(:lostPlace IS NULL OR b.lostPlace = :lostPlace) AND " +
            "(:lostDate IS NULL OR b.lostDate = :lostDate) AND " +
            "(:lostPropertyName IS NULL OR b.lostPropertyName LIKE %:lostPropertyName%)")
    List<LostPropertyBoardEntity> searchBoards(
            @Param("classifiName") String classifiName,
            @Param("lostArea") String lostArea,
            @Param("lostPlace") String lostPlace,
            @Param("lostDate") LocalDate lostDate,
            @Param("lostPropertyName") String lostPropertyName);
}
