package com.project.pathfinder.board.service.Comment;

import com.project.pathfinder.board.entity.Comment.LostPropertyCommentEntity;
import com.project.pathfinder.board.repository.Comment.LostPropertyCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostPropertyCommentService {

    @Autowired
    private LostPropertyCommentRepository commentRepository;

    public LostPropertyCommentEntity createComment(LostPropertyCommentEntity comment) {
        return commentRepository.save(comment);
    }

    public List<LostPropertyCommentEntity> getCommentsByBoardId(Long boardId) {
        return commentRepository.findByBoard_Id(boardId);
    }

    public LostPropertyCommentEntity updateComment(Long commentId, LostPropertyCommentEntity updatedComment) {
        updatedComment.setId(commentId);
        return commentRepository.save(updatedComment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
