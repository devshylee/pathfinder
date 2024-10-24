package com.project.pathfinder.board.repository.Board;

import com.project.pathfinder.board.entity.Board.AcquirePropertyBoardEntity;
import com.project.pathfinder.board.entity.Board.LostPropertyBoardEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AcquirePropertyBoardRepository extends JpaRepository<AcquirePropertyBoardEntity, Long> {

    Optional<AcquirePropertyBoardEntity> findById(Long id);

    @Query("SELECT b FROM AcquirePropertyBoardEntity b ORDER BY b.createDate DESC")
    List<AcquirePropertyBoardEntity> findTop4ByOrderByCreateDateDesc(Pageable pageable);

//    @Query("SELECT b FROM AcquirePropertyBoardEntity b WHERE b.boardTitle LIKE %:keyword%")
//    List<AcquirePropertyBoardEntity> findByBoardTitleContaining(@Param("keyword") String keyword);

    List<AcquirePropertyBoardEntity> findByBoardTitleContaining(String boardTitle);


    @Query("SELECT b FROM AcquirePropertyBoardEntity b WHERE " +
            "(:classifiName IS NULL OR b.classifiName = :classifiName) AND " +
            "(:acquireArea IS NULL OR b.acquireArea = :acquireArea) AND " +
            "(:acquirePlace IS NULL OR b.acquirePlace = :acquirePlace) AND " +
            "(:acquireDate IS NULL OR b.acquireDate = :acquireDate) AND " +
            "(:acquirePropertyName IS NULL OR b.acquirePropertyName LIKE %:acquirePropertyName%)")
    List<AcquirePropertyBoardEntity> searchBoards(
            @Param("classifiName") String classifiName,
            @Param("acquireArea") String acquireArea,
            @Param("acquirePlace") String acquirePlace,
            @Param("acquireDate") LocalDate acquireDate,
            @Param("acquirePropertyName") String acquirePropertyName);

}
