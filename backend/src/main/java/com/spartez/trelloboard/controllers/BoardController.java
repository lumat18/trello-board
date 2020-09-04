package com.spartez.trelloboard.controllers;

import com.spartez.trelloboard.domain.Board;
import com.spartez.trelloboard.services.BoardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/{id}")
    @ResponseStatus()
    public Board getBoard(@PathVariable(name = "id") final Long boardId) {
        return boardService.getBoard(boardId);
    }
}
