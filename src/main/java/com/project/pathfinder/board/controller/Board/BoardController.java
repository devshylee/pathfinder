package com.project.pathfinder.board.controller.Board;

import com.project.pathfinder.board.service.Board.BoardSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {


    private final BoardSearchService boardSearchService;

    public BoardController(BoardSearchService boardSearchService) {
        this.boardSearchService = boardSearchService;
    }

    @GetMapping("/search-all")
    public ResponseEntity<List<Object>> searchAllBoards(@RequestParam("title") String boardTitle) {
        try {
            List<Object> results = boardSearchService.searchAllBoardsByTitle(boardTitle);
            return new ResponseEntity<>(results, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

