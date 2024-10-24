package com.project.pathfinder.board.controller.Comment;

import com.project.pathfinder.board.entity.Comment.AcquirePropertyCommentEntity;
import com.project.pathfinder.board.entity.Comment.LostPetCommentEntity;
import com.project.pathfinder.board.entity.Comment.WantedCommentEntity;
import com.project.pathfinder.board.service.Comment.AcquirePropertyCommentService;
import com.project.pathfinder.board.service.Comment.LostPetCommentService;
import com.project.pathfinder.board.service.Comment.WantedCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wanted/comments")
public class WantedCommentContoller {

    @Autowired
    private WantedCommentService commentService;

    @GetMapping
    public ResponseEntity<List<WantedCommentEntity>> getAllComments() {
        try {
            List<WantedCommentEntity> comments = commentService.getAllComments();
            return new ResponseEntity<>(comments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // 댓글 생성
    @PostMapping
    public ResponseEntity<WantedCommentEntity> createComment(@RequestBody WantedCommentEntity comment) {
        try {
            WantedCommentEntity createdComment = commentService.createComment(comment);
            return new ResponseEntity<>(createdComment, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // 특정 게시판의 댓글 조회
    @GetMapping("/board/{boardId}")
    public ResponseEntity<List<WantedCommentEntity>> getCommentsByBoardId(@PathVariable Long boardId) {
        try {
            List<WantedCommentEntity> comments = commentService.getCommentsByBoardId(boardId);
            return new ResponseEntity<>(comments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // 댓글 수정
    @PutMapping("/{commentId}")
    public ResponseEntity<WantedCommentEntity> updateComment(@PathVariable Long commentId,
                                                              @RequestBody WantedCommentEntity updatedComment) {
        try {
            WantedCommentEntity comment = commentService.updateComment(commentId, updatedComment);
            return new ResponseEntity<>(comment, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // 댓글 삭제
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        try {
            commentService.deleteComment(commentId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
