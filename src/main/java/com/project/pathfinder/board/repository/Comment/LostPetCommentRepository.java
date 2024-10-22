package com.project.pathfinder.board.repository.Comment;

import com.project.pathfinder.board.entity.Comment.LostPetCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LostPetCommentRepository extends JpaRepository<LostPetCommentEntity, Long> {
    List<LostPetCommentEntity> findByBoard_Id(Long boardId); // 게시판 ID로 댓글 조회
}
