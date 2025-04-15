package com.project.pathfinder.board.controller.Board;

import com.project.pathfinder.board.entity.Board.LostPetBoardEntity;
import com.project.pathfinder.board.entity.Board.WantedBoardEntity;
import com.project.pathfinder.board.service.Board.WantedBoardService;
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
@RequestMapping("/boards/wanted-board")
public class WantedBoardController {


    @Autowired
    private WantedBoardService wantedBoardService;

    @Autowired
    private MemberService memberService;

    // 모든 게시물 가져오기
    @GetMapping
    public ResponseEntity<?> getAllWantedBoards() {
        try {
            List<WantedBoardEntity> boards = wantedBoardService.getWantedBoards();
            return new ResponseEntity<>(boards, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("분실물 게시판 조회 실패", HttpStatus.BAD_REQUEST);
        }
    }

    // 특정 게시물 조회
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getWantedBoardById(@PathVariable Long id) {
//        try {
//            Optional<WantedBoardEntity> board = wantedBoardService.getLostPetBoardById(id);
//            return new ResponseEntity<>(board, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("해당 게시글을 찾을 수 없습니다", HttpStatus.BAD_REQUEST);
//        }
//    }

    // 게시물 작성
    @PostMapping
    public ResponseEntity<?> createWantedBoard(@RequestBody WantedBoardEntity board) {
        try {

            // memberNickName을 이용해 MemberEntity 조회 또는 생성
            Optional<MemberEntity> member = memberService.getMemberByMemberNickName(board.getMember().getMemberNickName());

            if (member.isEmpty()) {
                return new ResponseEntity<>("유효하지 않은 사용자", HttpStatus.BAD_REQUEST);
            }

            // MemberEntity를 AcquirePropertyBoardEntity에 설정
            board.setMember(member.get());

            wantedBoardService.saveWantedBoard(board);
            return new ResponseEntity<>("분실물 게시글 작성 성공", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("게시글 작성 중 오류 발생", HttpStatus.BAD_REQUEST);
        }
    }

    // 게시물 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> updateWantedBoard(@PathVariable Long id, @RequestBody WantedBoardEntity board) {
        try {
            wantedBoardService.saveWantedBoard(board);
            return new ResponseEntity<>("게시글 수정 성공", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("게시글 수정 중 오류 발생", HttpStatus.BAD_REQUEST);
        }
    }

    // 게시물 삭제
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteWantedBoard(@PathVariable Long id) {
//        try {
//            wantedBoardService.deleteWantedBoard(id);
//            return new ResponseEntity<>("게시글 삭제 성공", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("게시글 삭제 중 오류 발생", HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/recent")
//    public ResponseEntity<?> getRecentWantedBoards() {
//        try{
//            List<WantedBoardEntity> wantedBoards = wantedBoardService.getRecentPosts();
//            return new ResponseEntity<>(wantedBoards, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("최근 게시물을 불러오는 중 에러 발생! /n [ERROR] : " + e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/search")
//    public ResponseEntity<List<WantedBoardEntity>> searchBoards(
//            @RequestParam(required = false) String classifiName,
//            @RequestParam(required = false) String lostArea,
//            @RequestParam(required = false) String lostPlace,
//            @RequestParam(required = false) LocalDate lostDate,
//            @RequestParam(required = false) String request_cost,
//            @RequestParam(required = false) String lostPropertyName) {
//        try {
//            List<WantedBoardEntity> boards = wantedBoardService.searchBoards(classifiName, lostArea, lostPlace, lostDate, request_cost, lostPropertyName);
//            return new ResponseEntity<>(boards, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }
}
