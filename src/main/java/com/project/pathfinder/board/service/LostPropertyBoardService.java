package com.project.pathfinder.board.service;

import com.project.pathfinder.board.entity.LostPetBoardEntity;
import com.project.pathfinder.board.entity.LostPropertyBoardEntity;
import com.project.pathfinder.board.repository.LostPropertyBoardRepository;
import com.project.pathfinder.member.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}

