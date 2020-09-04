package com.spartez.trelloboard.services;

import com.spartez.trelloboard.domain.Column;
import com.spartez.trelloboard.repositories.ColumnRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnService {

    private final ColumnRepository columnRepository;

    public ColumnService(ColumnRepository columnRepository) {
        this.columnRepository = columnRepository;
    }

    public List<Column> getAllColumnsByBoard(final Long boardId){
        return columnRepository.findAllByBoardId(boardId);
    }
}
