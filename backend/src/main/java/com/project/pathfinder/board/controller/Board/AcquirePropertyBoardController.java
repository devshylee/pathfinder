package com.project.pathfinder.board.controller.Board;

import com.project.pathfinder.board.entity.Board.AcquirePropertyBoardEntity;
import com.project.pathfinder.board.service.Board.AcquirePropertyBoardService;
import com.project.pathfinder.member.entity.MemberEntity;
import com.project.pathfinder.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boards/acquire-property-board")
public class AcquirePropertyBoardController {

    @Autowired
    private AcquirePropertyBoardService acquirePropertyBoardService;

    @Autowired
    private MemberService memberService;

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

            // memberNickName을 이용해 MemberEntity 조회 또는 생성
            Optional<MemberEntity> member = memberService.getMemberByMemberNickName(board.getMember().getMemberNickName());

            if (member.isEmpty()) {
                return new ResponseEntity<>("유효하지 않은 사용자", HttpStatus.BAD_REQUEST);
            }

            // MemberEntity를 AcquirePropertyBoardEntity에 설정
            board.setMember(member.get());

            acquirePropertyBoardService.saveAcquirePropertyBoard(board);
            return new ResponseEntity<>("습득물 게시글 작성 성공", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("게시글 작성 중 오류 발생", HttpStatus.BAD_REQUEST);
        }
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getAcquirePropertyBoardById(@PathVariable Long id) {
//        try {
//            Optional<AcquirePropertyBoardEntity> board = acquirePropertyBoardService.getAcquirePropertyBoardById(id);
//            return new ResponseEntity<>(board, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("해당 게시글을 찾을 수 없습니다", HttpStatus.BAD_REQUEST);
//        }
//    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAcquirePropertyBoard(@PathVariable Long id, @RequestBody AcquirePropertyBoardEntity board) {
        try {
            acquirePropertyBoardService.saveAcquirePropertyBoard(board);
            return new ResponseEntity<>("게시글 수정 성공", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("게시글 수정 중 오류 발생", HttpStatus.BAD_REQUEST);
        }
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteAcquirePropertyBoard(@PathVariable Long id) {
//        try {
//            acquirePropertyBoardService.deleteAcquirePropertyBoard(id);
//            return new ResponseEntity<>("게시글 삭제 성공", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("게시글 삭제 중 오류 발생", HttpStatus.BAD_REQUEST);
//        }
//    }

//    @GetMapping("/recent")
//    public ResponseEntity<?> getRecentAcquirePropertyBoards() {
//        try{
//            List<AcquirePropertyBoardEntity> acquirePropertyBoards = acquirePropertyBoardService.getRecentPosts();
//            return new ResponseEntity<>(acquirePropertyBoards, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("최근 게시물을 불러오는 중 에러 발생! /n [ERROR] : " + e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

//    @GetMapping("/search")
//    public ResponseEntity<List<AcquirePropertyBoardEntity>> searchBoards(
//            @RequestParam(required = false) String classifiName,
//            @RequestParam(required = false) String acquireArea,
//            @RequestParam(required = false) String acquirePlace,
//            @RequestParam(required = false) LocalDate lostDate,
//            @RequestParam(required = false) String acquirePropertyName) {
//        try {
//
//            System.out.println("search메서드 호출");
//            List<AcquirePropertyBoardEntity> boards = acquirePropertyBoardService.searchBoards(classifiName, acquireArea, acquirePlace, lostDate, acquirePropertyName);
//            System.out.println("search메서드 작동");
//            return new ResponseEntity<>(boards, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }
}
