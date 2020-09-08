package com.spartez.trelloboard.controllers;

import com.spartez.trelloboard.domain.Column;
import com.spartez.trelloboard.services.ColumnService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/column")
public class ColumnController {
    private final ColumnService columnService;

    public ColumnController(ColumnService columnService) {
        this.columnService = columnService;
    }

    @PostMapping("/create")
    public Column createColumn(@RequestBody final Column column, @RequestParam final Long boardId){
        return columnService.createColumn(column, boardId);
    }
}
