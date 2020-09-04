package com.spartez.trelloboard.services;

import com.spartez.trelloboard.domain.Board;
import com.spartez.trelloboard.domain.Column;
import com.spartez.trelloboard.repositories.BoardRepository;
import com.spartez.trelloboard.repositories.ColumnRepository;
import com.spartez.trelloboard.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    public Board createBoard(final Board board){
        board.getColumns().forEach(column -> column.getTasks().forEach(taskRepository::save));
        board.getColumns().forEach(columnRepository::save);
        return boardRepository.save(board);
    }
}
