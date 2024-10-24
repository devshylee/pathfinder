package com.project.pathfinder.board.service.Board;

import com.project.pathfinder.board.entity.Board.AcquirePropertyBoardEntity;
import com.project.pathfinder.board.entity.Board.LostPetBoardEntity;
import com.project.pathfinder.board.entity.Board.LostPropertyBoardEntity;
import com.project.pathfinder.board.repository.Board.LostPetBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LostPetBoardService {

    private final LostPetBoardRepository lostPetBoardRepository;

    public List<LostPetBoardEntity> getLostPetBoards() {
        return lostPetBoardRepository.findAll();
    }

    public Optional<LostPetBoardEntity> getLostPetBoardById(Long id) {
        return lostPetBoardRepository.findById(id);
    }

    public void saveLostPetBoard(LostPetBoardEntity board) {
        lostPetBoardRepository.save(board);
    }

    public void deleteLostPetBoard(Long id) {
        lostPetBoardRepository.deleteById(id);
    }

    public List<LostPetBoardEntity> getRecentPosts() {
        Pageable topFour = PageRequest.of(0, 4);
        return lostPetBoardRepository.findTop4ByOrderByCreateDateDesc(topFour);
    }

    public List<LostPetBoardEntity> searchBoards(String classifiName, String findArea,
                                                      String findPlace, LocalDate lostDate,
                                                      String petName) {
        return lostPetBoardRepository.searchBoards(classifiName, findArea, findPlace, lostDate, petName);
    }

}
