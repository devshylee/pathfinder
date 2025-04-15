package com.project.pathfinder.board.repository.Comment;


import com.project.pathfinder.board.entity.Comment.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    // 특정 게시글의 모든 댓글 조회
    List<CommentEntity> findByBoardId(Long boardId);

}
