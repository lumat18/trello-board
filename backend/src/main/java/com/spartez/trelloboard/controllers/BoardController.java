package com.spartez.trelloboard.controllers;

import com.spartez.trelloboard.domain.Board;
import com.spartez.trelloboard.services.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public String hello(){
        return "hello";
    }

    @PostMapping
    public Board createBoard(@RequestBody final Board board) {
        log.info("Resource uploaded: " + board.toString());
        return boardService.createBoard(board);
    }
}
