package com.project.pathfinder.board.controller;

import com.project.pathfinder.board.entity.AcquirePropertyBoardEntity;
import com.project.pathfinder.board.service.AcquirePropertyBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boards/acquire-property-board")
public class AcquirePropertyBoardController {

    @Autowired
    private AcquirePropertyBoardService acquirePropertyBoardService;

    @GetMapping
    public ResponseEntity<?> getAllAcquirePropertyBoards() {
        try {
            List<AcquirePropertyBoardEntity> boards = acquirePropertyBoardService.getAcquirePropertyBoards();
            return new ResponseEntity<>(boards, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("습득물 게시판 조회 실패", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> createAcquirePropertyBoard(@RequestBody AcquirePropertyBoardEntity board) {
        try {
            acquirePropertyBoardService.saveAcquirePropertyBoard(board);
            return new ResponseEntity<>("습득물 게시글 작성 성공", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("게시글 작성 중 오류 발생", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAcquirePropertyBoardById(@PathVariable Long id) {
        try {
            Optional<AcquirePropertyBoardEntity> board = acquirePropertyBoardService.getAcquirePropertyBoardById(id);
            return new ResponseEntity<>(board, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("해당 게시글을 찾을 수 없습니다", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAcquirePropertyBoard(@PathVariable Long id, @RequestBody AcquirePropertyBoardEntity board) {
        try {
            acquirePropertyBoardService.saveAcquirePropertyBoard(board);
            return new ResponseEntity<>("게시글 수정 성공", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("게시글 수정 중 오류 발생", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAcquirePropertyBoard(@PathVariable Long id) {
        try {
            acquirePropertyBoardService.deleteAcquirePropertyBoard(id);
            return new ResponseEntity<>("게시글 삭제 성공", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("게시글 삭제 중 오류 발생", HttpStatus.BAD_REQUEST);
        }
    }
}
