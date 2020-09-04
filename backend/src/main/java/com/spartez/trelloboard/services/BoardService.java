package com.spartez.trelloboard.services;

import com.spartez.trelloboard.domain.Board;
import com.spartez.trelloboard.repositories.BoardRepository;
import com.spartez.trelloboard.repositories.ColumnRepository;
import com.spartez.trelloboard.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;
    private final ColumnRepository columnRepository;
    private final TaskRepository taskRepository;

    public BoardService(BoardRepository boardRepository, ColumnRepository columnRepository, TaskRepository taskRepository) {
        this.boardRepository = boardRepository;
        this.columnRepository = columnRepository;
        this.taskRepository = taskRepository;
    }

    public Board getBoard(final Long boardId) {
        return boardRepository.findById(boardId).orElseThrow();
    }
}
