package com.project.pathfinder.board.service.Comment;

import com.project.pathfinder.board.entity.Comment.AcquirePropertyCommentEntity;
import com.project.pathfinder.board.entity.Comment.LostPetCommentEntity;
import com.project.pathfinder.board.entity.Comment.LostPropertyCommentEntity;
import com.project.pathfinder.board.repository.Comment.AcquirePropertyCommentRepository;
import com.project.pathfinder.board.repository.Comment.LostPetCommentRepository;
import com.project.pathfinder.board.repository.Comment.LostPropertyCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostPetCommentService {

    @Autowired
    private LostPetCommentRepository commentRepository;

    public LostPetCommentEntity createComment(LostPetCommentEntity comment) {
        return commentRepository.save(comment);
    }

    public List<LostPetCommentEntity> getCommentsByBoardId(Long boardId) {
        return commentRepository.findByBoard_Id(boardId);
    }

    public LostPetCommentEntity updateComment(Long commentId, LostPetCommentEntity updatedComment) {
        updatedComment.setId(commentId);
        return commentRepository.save(updatedComment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
