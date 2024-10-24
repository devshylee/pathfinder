package com.project.pathfinder.board.service.Board;

import com.project.pathfinder.board.entity.Board.LostPetBoardEntity;
import com.project.pathfinder.board.entity.Board.LostPropertyBoardEntity;
import com.project.pathfinder.board.entity.Board.WantedBoardEntity;
import com.project.pathfinder.board.repository.Board.WantedBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WantedBoardService {

    private final WantedBoardRepository wantedBoardRepository;

    public List<WantedBoardEntity> getWantedBoards() {
        return wantedBoardRepository.findAll();
    }

    public Optional<WantedBoardEntity> getLostPetBoardById(Long id) {
        return wantedBoardRepository.findById(id);
    }

    public void saveWantedBoard(WantedBoardEntity board) {
        wantedBoardRepository.save(board);
    }

    public void deleteWantedBoard(Long id) {
        wantedBoardRepository.deleteById(id);
    }

    public List<WantedBoardEntity> getRecentPosts() {
        Pageable topFour = PageRequest.of(0, 4);
        return wantedBoardRepository.findTop4ByOrderByCreateDateDesc(topFour);
    }

    public List<WantedBoardEntity> searchBoards(String classifiName, String lostArea,
                                                      String lostPlace, LocalDate lostDate,
                                                    String request_cost, String lostPropertyName) {
        return wantedBoardRepository.searchBoards(classifiName, lostArea, lostPlace, lostDate, request_cost, lostPropertyName);
    }
}
