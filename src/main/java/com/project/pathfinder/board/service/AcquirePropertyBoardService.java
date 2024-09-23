package com.project.pathfinder.board.service;

import com.project.pathfinder.board.entity.AcquirePropertyBoardEntity;
import com.project.pathfinder.board.entity.LostPropertyBoardEntity;
import com.project.pathfinder.board.repository.AcquirePropertyBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AcquirePropertyBoardService {

    private final AcquirePropertyBoardRepository acquirePropertyBoardRepository;

    public List<AcquirePropertyBoardEntity> getAcquirePropertyBoards() {
        return acquirePropertyBoardRepository.findAll();
    }

    public Optional<AcquirePropertyBoardEntity> getAcquirePropertyBoardById(Long id) {
        return acquirePropertyBoardRepository.findById(id);
    }

    public void saveAcquirePropertyBoard(AcquirePropertyBoardEntity board) {
        acquirePropertyBoardRepository.save(board);
    }

    public void deleteAcquirePropertyBoard(Long id) {
        acquirePropertyBoardRepository.deleteById(id);
    }
}
