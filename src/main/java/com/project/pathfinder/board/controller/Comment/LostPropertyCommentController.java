package com.project.pathfinder.board.controller.Comment;

import com.project.pathfinder.board.entity.Comment.LostPropertyCommentEntity;
import com.project.pathfinder.board.service.Comment.LostPropertyCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lost-property/comments")
public class LostPropertyCommentController {

    @Autowired
    private LostPropertyCommentService commentService;

    // 댓글 생성
    @PostMapping
    public ResponseEntity<LostPropertyCommentEntity> createComment(@RequestBody LostPropertyCommentEntity comment) {
        try {
            LostPropertyCommentEntity createdComment = commentService.createComment(comment);
            return new ResponseEntity<>(createdComment, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // 특정 게시판의 댓글 조회
    @GetMapping("/board/{boardId}")
    public ResponseEntity<List<LostPropertyCommentEntity>> getCommentsByBoardId(@PathVariable Long boardId) {
        try {
            List<LostPropertyCommentEntity> comments = commentService.getCommentsByBoardId(boardId);
            return new ResponseEntity<>(comments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // 댓글 수정
    @PutMapping("/{commentId}")
    public ResponseEntity<LostPropertyCommentEntity> updateComment(@PathVariable Long commentId,
                                                                   @RequestBody LostPropertyCommentEntity updatedComment) {
        try {
            LostPropertyCommentEntity comment = commentService.updateComment(commentId, updatedComment);
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
