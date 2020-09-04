package com.spartez.trelloboard.bootstrap;

import com.spartez.trelloboard.domain.Board;
import com.spartez.trelloboard.domain.Column;
import com.spartez.trelloboard.domain.Task;
import com.spartez.trelloboard.repositories.BoardRepository;
import com.spartez.trelloboard.repositories.ColumnRepository;
import com.spartez.trelloboard.repositories.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class InitDatabase implements CommandLineRunner {
    private final TaskRepository taskRepository;
    private final ColumnRepository columnRepository;
    private final BoardRepository boardRepository;

    public InitDatabase(TaskRepository taskRepository, ColumnRepository columnRepository, BoardRepository boardRepository) {
        this.taskRepository = taskRepository;
        this.columnRepository = columnRepository;
        this.boardRepository = boardRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Column todo = new Column("todo");
        Column inProgress = new Column("in-progress");
        Column done = new Column("done");

        List<Column> columns = List.of(todo, inProgress, done);

        Task task1 = new Task("walk the dog", "", "Torin", todo);
        Task task2 = new Task("eat lunch", "", "Torin", todo);
        Task task3 = new Task("drink coffee", "", "Lucas", inProgress);
        Task task4 = new Task("go shopping", "", "Greg", done);
        Task task5 = new Task("take a nap", "", "Sleeper", done);
        Task task6 = new Task("learn programming", "", "Lucas", done);

        List<Task> tasks = List.of(task1, task2, task3, task4, task5, task6);

        Board board = new Board("default-board", columns);

        columns.forEach(columnRepository::save);
        tasks.forEach(taskRepository::save);
        boardRepository.save(board);
    }
}
