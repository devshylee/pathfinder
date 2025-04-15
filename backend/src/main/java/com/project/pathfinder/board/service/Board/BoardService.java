package com.project.pathfinder.board.service.Board;

import com.project.pathfinder.board.entity.Board.*;
import com.project.pathfinder.board.repository.Board.AcquirePropertyBoardRepository;
import com.project.pathfinder.board.repository.Board.LostPetBoardRepository;
import com.project.pathfinder.board.repository.Board.LostPropertyBoardRepository;
import com.project.pathfinder.board.repository.Board.WantedBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private AcquirePropertyBoardRepository acquirePropertyBoardRepository;

    @Autowired
    private LostPetBoardRepository lostPetBoardRepository;

    @Autowired
    private LostPropertyBoardRepository lostPropertyBoardRepository;

    @Autowired
    private WantedBoardRepository wantedBoardRepository;


    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 검색 서비스 로직 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    // Id를 기준으로 테이블에서 검색
    public BoardEntity getBoardById(String boardType, Long id) {
        Optional<? extends BoardEntity> boardEntity;

        switch (boardType) {
            case "AcquireProperty":
                boardEntity = acquirePropertyBoardRepository.findById(id);
                break;
            case "LostPet":
                boardEntity = lostPetBoardRepository.findById(id);
                break;
            case "LostProperty":
                boardEntity = lostPropertyBoardRepository.findById(id);
                break;
            case "Wanted":
                boardEntity = wantedBoardRepository.findById(id);
                break;
            default:
                throw new IllegalArgumentException("잘못된 게시판 유형");
        }

        return boardEntity.orElseThrow(() -> new IllegalArgumentException("해당 ID의 게시물이 없습니다."));
    }

    // BaordType을 기준으로 테이블에서 모든 요소 검색
    public List<? extends BoardEntity> getBoardsByType(String boardType) {
        switch (boardType) {
            case "AcquireProperty":
                return acquirePropertyBoardRepository.findAll();
            case "LostPet":
                return lostPetBoardRepository.findAll();
            case "LostProperty":
                return lostPropertyBoardRepository.findAll();
            case "Wanted":
                return wantedBoardRepository.findAll();
            default:
                throw new IllegalArgumentException("잘못된 게시판 유형");
        }
    }

    // 최근 게시물 4개를 반환
    public BoardEntity getBoardByRecentTop4(String boardType) {

        Optional<? extends BoardEntity> boardEntity;

        Pageable topFour = PageRequest.of(0, 4);

        switch (boardType) {
            case "AcquireProperty":
                return (BoardEntity) acquirePropertyBoardRepository.findTop4ByOrderByCreateDateDesc(topFour);
            case "Lostpet":
                return (BoardEntity) lostPetBoardRepository.findTop4ByOrderByCreateDateDesc(topFour);
            case "LostProperty":
                return (BoardEntity) lostPropertyBoardRepository.findTop4ByOrderByCreateDateDesc(topFour);
            case "Wanted":
                return (BoardEntity) wantedBoardRepository.findTop4ByOrderByCreateDateDesc(topFour);
            default:
                throw new IllegalArgumentException("잘못된 게시판 유형");
        }
    }

    // 메인페이지 검색기능

    // 게시판별 상세 검색기능

    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 검색 서비스 로직 끝 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ



    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 삽입, 삭제 서비스 로직 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    public void saveBoard(String boardType, BoardEntity board) {

        switch (boardType) {
            case "AcquireProperty":
                acquirePropertyBoardRepository.save((AcquirePropertyBoardEntity) board);
                break;
            case "LostPet":
                lostPetBoardRepository.save((LostPetBoardEntity) board);
                break;
            case "LostProperty":
                lostPropertyBoardRepository.save((LostPropertyBoardEntity) board);
                break;
            case "Wanted":
                wantedBoardRepository.save((WantedBoardEntity) board);
                break;
            default:
                throw new IllegalArgumentException("잘못된 게시판 유형");

        }
    }


    public void updateBoard(String boardType, BoardEntity board, long id) {

            switch (boardType) {
                case "acquire-property":
                    acquirePropertyBoardRepository.save((AcquirePropertyBoardEntity) board);
                    break;
                case "lost-pet":
                    lostPetBoardRepository.save((LostPetBoardEntity) board);
                    break;
                case "lost-property":
                    lostPropertyBoardRepository.save((LostPropertyBoardEntity) board);
                    break;
                case "wanted":
                    wantedBoardRepository.save((WantedBoardEntity) board);
                    break;
                default:
                    throw new IllegalArgumentException("잘못된 게시판 유형");

        }
    }

    public void deleteBoard(String boardType, long id) {
        switch (boardType) {
            case "acquire-property":
                acquirePropertyBoardRepository.deleteById(id);
                break;
            case "lost-pet":
                lostPetBoardRepository.deleteById(id);
                break;
            case "lost-property":
                lostPropertyBoardRepository.deleteById(id);
                break;
            case "wanted":
                wantedBoardRepository.deleteById(id);

                break;
            default:
                throw new IllegalArgumentException("잘못된 게시판 유형");
        }
    }

}
