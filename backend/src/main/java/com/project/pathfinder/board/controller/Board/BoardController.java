package com.project.pathfinder.board.controller.Board;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.pathfinder.board.service.Board.BoardService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pathfinder.board.entity.Board.*;
import com.project.pathfinder.member.entity.MemberEntity;
import com.project.pathfinder.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ObjectMapper objectMapper;

    // 모든 게시물 가져오기 (acquire property, lost pet, lost property, wanted)
//    @GetMapping
//    public ResponseEntity<?> getAllBoards() {
//        try {
//            List<AcquirePropertyBoardEntity> acquireBoards = boardService.getAcquirePropertyBoards();
//            List<LostPetBoardEntity> lostPetBoards = boardService.getLostPetBoards();
//            List<LostPropertyBoardEntity> lostPropertyBoards = boardService.getLostPropertyBoards();
//            List<WantedBoardEntity> wantedBoards = boardService.getWantedBoards();
//
//            return new ResponseEntity<>(List.of(acquireBoards, lostPetBoards, lostPropertyBoards, wantedBoards), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("게시판 조회 실패", HttpStatus.BAD_REQUEST);
//        }
//    }


    @PostMapping("/{boardType}")
    public ResponseEntity<?> createBoard(
            @PathVariable String boardType,
            @RequestBody Map<String, Object> boardData) {
        try {
            // JSON 데이터를 특정 BoardEntity 클래스로 변환

            BoardEntity board = objectMapper.convertValue(boardData, getBoardClass(boardType));

            Optional<MemberEntity> member = memberService.getMemberByMemberNickName(board.getMember().getMemberNickName());

            if (member.isEmpty()) {
                return new ResponseEntity<>("유효하지 않은 사용자", HttpStatus.BAD_REQUEST);
            }

            board.setMember(member.get());

            boardService.saveBoard(boardType, board);

            return new ResponseEntity<>(boardType + " 게시글 작성 성공", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("게시글 작성 중 오류 발생", HttpStatus.BAD_REQUEST);
        }
    }

    // 특정 게시판의 모든 게시물 조회
    @GetMapping("/{boardType}")
    public ResponseEntity<?> getBoardByType(@PathVariable String boardType) {
        try {
            List<? extends BoardEntity> board = boardService.getBoardsByType(boardType);

            return new ResponseEntity<>(board, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("해당 게시글을 찾을 수 없습니다", HttpStatus.BAD_REQUEST);
        }
    }

//     게시물 수정
    @PutMapping("/{boardType}/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable String boardType, @PathVariable Long id, @RequestBody List<? extends BoardEntity> board) {
        try {

            Optional<MemberEntity> member = memberService.getMemberByMemberNickName(board.get(0).getMember().getMemberNickName());

            if (member.isEmpty()) {
                return new ResponseEntity<>("유효하지 않은 사용자", HttpStatus.BAD_REQUEST);
            }

            for (BoardEntity b : board) {
                b.setMember(member.get());
            }

            boardService.updateBoard(boardType, (BoardEntity) board, id);

            return new ResponseEntity<>("게시글 수정 성공", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("게시글 수정 중 오류 발생", HttpStatus.BAD_REQUEST);
        }
    }

//     게시물 삭제
    @DeleteMapping("/{boardType}/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable String boardType, @PathVariable Long id) {
        try {

            boardService.deleteBoard(boardType, id);

            return new ResponseEntity<>("게시글 삭제 성공", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("게시글 삭제 중 오류 발생", HttpStatus.BAD_REQUEST);
        }
    }
//
//    // 최근 게시물 가져오기 (acquire property, lost pet, lost property, wanted)
    @GetMapping("/{boardType}/recent")
    public ResponseEntity<?> getRecentBoards(@PathVariable String boardType) {
        try {

            BoardEntity top4board = boardService.getBoardByRecentTop4(boardType);

            return new ResponseEntity<>(top4board, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("최근 게시물을 불러오는 중 에러 발생", HttpStatus.BAD_REQUEST);
        }
    }

    // 게시물 검색 (acquire property, lost pet, lost property, wanted)
//    @GetMapping("/search")
//    public ResponseEntity<List<?>> searchBoards(
//            @RequestParam String type,
//            @RequestParam(required = false) String classifiName,
//            @RequestParam(required = false) String area,
//            @RequestParam(required = false) String place,
//            @RequestParam(required = false) LocalDate lostDate,
//            @RequestParam(required = false) String propertyName) {
//        try {
//            List<?> boards;
//            switch (type) {
//                case "acquire-property-board":
//                    boards = boardService.searchAcquirePropertyBoards(classifiName, area, place, lostDate, propertyName);
//                    break;
//                case "lost-pet-board":
//                    boards = boardService.searchLostPetBoards(classifiName, area, place, lostDate, propertyName);
//                    break;
//                case "lost-property-board":
//                    boards = boardService.searchLostPropertyBoards(classifiName, area, place, lostDate, propertyName);
//                    break;
//                case "wanted-board":
//                    boards = boardService.searchWantedBoards(classifiName, area, place, lostDate, propertyName);
//                    break;
//                default:
//                    return new ResponseEntity<>("게시판 유형이 유효하지 않습니다", HttpStatus.BAD_REQUEST);
//            }
//            return new ResponseEntity<>(boards, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }

    private Class<? extends BoardEntity> getBoardClass(String boardType) {
        switch (boardType) {
            case "AcquireProperty":
                return AcquirePropertyBoardEntity.class;
            case "LostProperty":
                return LostPropertyBoardEntity.class;
            case "LostPet":
                return LostPetBoardEntity.class;
            case "Wanted":
                return WantedBoardEntity.class;
            default:
                throw new IllegalArgumentException("유효하지 않은 boardType");
        }
    }
}



