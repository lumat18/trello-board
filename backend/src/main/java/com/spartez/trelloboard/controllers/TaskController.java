package com.spartez.trelloboard.controllers;

import com.spartez.trelloboard.domain.Column;
import com.spartez.trelloboard.domain.Task;
import com.spartez.trelloboard.services.ColumnService;
import com.spartez.trelloboard.services.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@Slf4j
public class TaskController {

    private final TaskService taskService;
    private final ColumnService columnService;

    public TaskController(TaskService taskService, ColumnService columnService) {
        this.taskService = taskService;
        this.columnService = columnService;
    }

    @PostMapping
    public Task createTask(@RequestBody final Task task, @RequestParam final Long columnId) {
        Column column = columnService.getColumnById(columnId);
        task.setColumn(column);
        return taskService.create(task);
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable(name = "id") final Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @GetMapping
    public List<Task> getTasksByColumn(@RequestParam(name = "columnId") final Long columnId) {
        return taskService.getTasksByColumn(columnId);
    }
}
