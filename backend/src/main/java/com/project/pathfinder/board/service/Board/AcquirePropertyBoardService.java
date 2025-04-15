package com.project.pathfinder.board.service.Board;

import com.project.pathfinder.board.entity.Board.AcquirePropertyBoardEntity;
import com.project.pathfinder.board.entity.Board.LostPropertyBoardEntity;
import com.project.pathfinder.board.repository.Board.AcquirePropertyBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AcquirePropertyBoardService {

    private final AcquirePropertyBoardRepository acquirePropertyBoardRepository;

    public List<AcquirePropertyBoardEntity> getAcquirePropertyBoards() {
        return acquirePropertyBoardRepository.findAll();
    }

//    public Optional<AcquirePropertyBoardEntity> getAcquirePropertyBoardById(Long id) {
//        return acquirePropertyBoardRepository.findById(id);
//    }

    public void saveAcquirePropertyBoard(AcquirePropertyBoardEntity board) {
        acquirePropertyBoardRepository.save(board);
    }

//    public void deleteAcquirePropertyBoard(Long id) {
//        acquirePropertyBoardRepository.deleteById(id);
//    }

//    public List<AcquirePropertyBoardEntity> getRecentPosts() {
//        Pageable topFour = PageRequest.of(0, 4);
//        return acquirePropertyBoardRepository.findTop4ByOrderByCreateDateDesc(topFour);
//    }

//    public List<AcquirePropertyBoardEntity> searchBoards(String classifiName, String acquireArea,
//                                                      String acquirePlace, LocalDate acquireDate,
//                                                      String acquirePropertyName) {
//        return acquirePropertyBoardRepository.searchBoards(classifiName, acquireArea, acquirePlace, acquireDate, acquirePropertyName);
//    }
}
