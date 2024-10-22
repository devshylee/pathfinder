package com.project.pathfinder.board.repository.Comment;

import com.project.pathfinder.board.entity.Comment.AcquirePropertyCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcquirePropertyCommentRepository extends JpaRepository<AcquirePropertyCommentEntity, Long> {
    List<AcquirePropertyCommentEntity> findByBoard_Id(Long boardId); // 게시판 ID로 댓글 조회
}
