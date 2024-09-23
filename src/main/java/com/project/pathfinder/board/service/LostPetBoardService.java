package com.project.pathfinder.board.service;

import com.project.pathfinder.board.entity.AcquirePropertyBoardEntity;
import com.project.pathfinder.board.entity.LostPetBoardEntity;
import com.project.pathfinder.board.repository.LostPetBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}
