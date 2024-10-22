package com.project.pathfinder.board.service.Comment;

import com.project.pathfinder.board.entity.Comment.AcquirePropertyCommentEntity;
import com.project.pathfinder.board.entity.Comment.LostPropertyCommentEntity;
import com.project.pathfinder.board.repository.Comment.AcquirePropertyCommentRepository;
import com.project.pathfinder.board.repository.Comment.LostPropertyCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcquirePropertyCommentService {

    @Autowired
    private AcquirePropertyCommentRepository commentRepository;

    public AcquirePropertyCommentEntity createComment(AcquirePropertyCommentEntity comment) {
        return commentRepository.save(comment);
    }

    public List<AcquirePropertyCommentEntity> getCommentsByBoardId(Long boardId) {
        return commentRepository.findByBoard_Id(boardId);
    }

    public AcquirePropertyCommentEntity updateComment(Long commentId, AcquirePropertyCommentEntity updatedComment) {
        updatedComment.setId(commentId);
        return commentRepository.save(updatedComment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
