package com.project.pathfinder.board.service.Board;

import com.project.pathfinder.board.entity.Board.LostPropertyBoardEntity;
import com.project.pathfinder.board.repository.Board.LostPropertyBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LostPropertyBoardService {

    private final LostPropertyBoardRepository lostPropertyBoardRepository;

    public List<LostPropertyBoardEntity> getLostPropertyBoards() {
        return lostPropertyBoardRepository.findAll();
    }

    public Optional<LostPropertyBoardEntity> getLostPetBoardById(Long id) {
        return lostPropertyBoardRepository.findById(id);
    }

    public void saveLostPropertyBoard(LostPropertyBoardEntity board) {
        lostPropertyBoardRepository.save(board);
    }

    public void deleteLostPropertyBoard(Long id) {
        lostPropertyBoardRepository.deleteById(id);
    }

    public List<LostPropertyBoardEntity> getRecentPosts() {
        Pageable topFour = PageRequest.of(0, 4);
        return lostPropertyBoardRepository.findTop4ByOrderByCreateDateDesc(topFour);
    }

    public List<LostPropertyBoardEntity> searchBoards(String classifiName, String lostArea,
                                                      String lostPlace, LocalDate lostDate,
                                                      String lostPropertyName) {
        return lostPropertyBoardRepository.searchBoards(classifiName, lostArea, lostPlace, lostDate, lostPropertyName);
    }
}

