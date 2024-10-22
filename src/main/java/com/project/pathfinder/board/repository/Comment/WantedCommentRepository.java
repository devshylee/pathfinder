package com.project.pathfinder.board.repository.Comment;

import com.project.pathfinder.board.entity.Comment.WantedCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WantedCommentRepository extends JpaRepository<WantedCommentEntity, Long> {
    List<WantedCommentEntity> findByBoard_Id(Long boardId); // 게시판 ID로 댓글 조회
}
