package com.project.pathfinder.board.service.Comment;

import com.project.pathfinder.board.entity.Comment.AcquirePropertyCommentEntity;
import com.project.pathfinder.board.entity.Comment.LostPetCommentEntity;
import com.project.pathfinder.board.entity.Comment.LostPropertyCommentEntity;
import com.project.pathfinder.board.entity.Comment.WantedCommentEntity;
import com.project.pathfinder.board.repository.Comment.AcquirePropertyCommentRepository;
import com.project.pathfinder.board.repository.Comment.LostPetCommentRepository;
import com.project.pathfinder.board.repository.Comment.LostPropertyCommentRepository;
import com.project.pathfinder.board.repository.Comment.WantedCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WantedCommentService {

    @Autowired
    private WantedCommentRepository commentRepository;

    public WantedCommentEntity createComment(WantedCommentEntity comment) {
        return commentRepository.save(comment);
    }

    public List<WantedCommentEntity> getCommentsByBoardId(Long boardId) {
        return commentRepository.findByBoard_Id(boardId);
    }

    public WantedCommentEntity updateComment(Long commentId, WantedCommentEntity updatedComment) {
        updatedComment.setId(commentId);
        return commentRepository.save(updatedComment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
