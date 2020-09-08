package com.spartez.trelloboard.services;

import com.spartez.trelloboard.domain.Board;
import com.spartez.trelloboard.domain.Column;
import com.spartez.trelloboard.repositories.BoardRepository;
import com.spartez.trelloboard.repositories.ColumnRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnService {

    private final ColumnRepository columnRepository;
    private final BoardRepository boardRepository;

    public ColumnService(ColumnRepository columnRepository, BoardRepository boardRepository) {
        this.columnRepository = columnRepository;
        this.boardRepository = boardRepository;
    }

    public List<Column> getAllColumnsByBoard(final Long boardId) {
        return columnRepository.findAllByBoardId(boardId);
    }

    public Column getColumnById(Long columnId) {
        return columnRepository.findById(columnId).orElseThrow();
    }

    public Column createColumn(final Column column, final Long boardId){
        Board board = boardRepository.findById(boardId).orElseThrow();
        Column savedColumn = columnRepository.save(column);
        board.getColumns().add(savedColumn);
        boardRepository.save(board);
        return savedColumn;
    }
}
