package com.project.pathfinder.board.controller.Comment;

import com.project.pathfinder.board.dto.CommentResponseDto;
import com.project.pathfinder.board.entity.Board.BoardEntity;
import com.project.pathfinder.board.entity.Comment.CommentEntity;
import com.project.pathfinder.board.service.Comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 작성
    @PostMapping("/{boardType}/{boardId}")
    public ResponseEntity<?> createComment(
            @PathVariable String boardType,
            @PathVariable Long boardId,
            @RequestParam String memberNickName,
            @RequestParam String content
    ) {
        try {
            CommentEntity comment = commentService.createComment(boardType, boardId, memberNickName, content);
            return ResponseEntity.ok(comment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 댓글 조회
    @GetMapping("/{boardType}/{boardId}")
    public ResponseEntity<?> getComments(
            @PathVariable String boardType,
            @PathVariable Long boardId) {
        try {
            // 게시글 찾기
            BoardEntity board = commentService.findBoardByIdAndType(boardType, boardId);
            if (board == null) {
                return ResponseEntity.badRequest().body("유효하지 않은 게시글입니다.");
            }

            // 해당 게시글의 댓글 가져오기
            List<CommentEntity> comments = commentService.getCommentsByBoard(boardId);

            // 응답 데이터 구성
            return ResponseEntity.ok(new CommentResponseDto(board, comments));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("댓글 조회 중 오류 발생");
        }
    }
}
