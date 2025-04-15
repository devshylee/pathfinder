//package com.project.pathfinder.board.service.Board;
//
//import com.project.pathfinder.board.repository.Board.AcquirePropertyBoardRepository;
//import com.project.pathfinder.board.repository.Board.LostPetBoardRepository;
//import com.project.pathfinder.board.repository.Board.LostPropertyBoardRepository;
//import com.project.pathfinder.board.repository.Board.WantedBoardRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class BoardSearchService {
//
//    private final AcquirePropertyBoardRepository acquirePropertyBoardRepository;
//    private final LostPropertyBoardRepository lostPropertyBoardRepository;
//    private final LostPetBoardRepository lostPetBoardRepository;
//    private final WantedBoardRepository wantedBoardRepository;
//
//    public BoardSearchService(
//            AcquirePropertyBoardRepository acquirePropertyBoardRepository,
//            LostPropertyBoardRepository lostPropertyBoardRepository,
//            LostPetBoardRepository lostPetBoardRepository,
//            WantedBoardRepository wantedBoardRepository) {
//        this.acquirePropertyBoardRepository = acquirePropertyBoardRepository;
//        this.lostPropertyBoardRepository = lostPropertyBoardRepository;
//        this.lostPetBoardRepository = lostPetBoardRepository;
//        this.wantedBoardRepository = wantedBoardRepository;
//    }
//
//    public List<Object> searchAllBoardsByTitle(String boardTitle) {
//        List<Object> results = new ArrayList<>();
//
//        // 각 게시판의 제목을 기준으로 검색 후 결과 합치기
//        results.addAll(acquirePropertyBoardRepository.findByBoardTitleContaining(boardTitle));
//        results.addAll(lostPropertyBoardRepository.findByBoardTitleContaining(boardTitle));
//        results.addAll(lostPetBoardRepository.findByBoardTitleContaining(boardTitle));
//        results.addAll(wantedBoardRepository.findByBoardTitleContaining(boardTitle));
//
//        return results;
//    }
//}
//
