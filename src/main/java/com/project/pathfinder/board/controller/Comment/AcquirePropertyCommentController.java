package com.project.pathfinder.board.controller.Comment;

import com.project.pathfinder.board.entity.Comment.AcquirePropertyCommentEntity;
import com.project.pathfinder.board.service.Comment.AcquirePropertyCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acquire-property/comments")
public class AcquirePropertyCommentController {

    @Autowired
    private AcquirePropertyCommentService commentService;

    @GetMapping
    public ResponseEntity<List<AcquirePropertyCommentEntity>> getAllComments() {
        try {
            List<AcquirePropertyCommentEntity> comments = commentService.getAllComments();
            return new ResponseEntity<>(comments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // 댓글 생성
    @PostMapping
    public ResponseEntity<AcquirePropertyCommentEntity> createComment(@RequestBody AcquirePropertyCommentEntity comment) {
        try {
            AcquirePropertyCommentEntity createdComment = commentService.createComment(comment);
            return new ResponseEntity<>(createdComment, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // 특정 게시판의 댓글 조회
    @GetMapping("/board/{boardId}")
    public ResponseEntity<List<AcquirePropertyCommentEntity>> getCommentsByBoardId(@PathVariable Long boardId) {
        try {
            List<AcquirePropertyCommentEntity> comments = commentService.getCommentsByBoardId(boardId);
            return new ResponseEntity<>(comments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // 댓글 수정
    @PutMapping("/{commentId}")
    public ResponseEntity<AcquirePropertyCommentEntity> updateComment(@PathVariable Long commentId,
                                                                   @RequestBody AcquirePropertyCommentEntity updatedComment) {
        try {
            AcquirePropertyCommentEntity comment = commentService.updateComment(commentId, updatedComment);
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
