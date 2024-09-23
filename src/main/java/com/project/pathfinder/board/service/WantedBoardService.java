package com.project.pathfinder.board.service;

import com.project.pathfinder.board.entity.LostPropertyBoardEntity;
import com.project.pathfinder.board.entity.WantedBoardEntity;
import com.project.pathfinder.board.repository.WantedBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}
