package com.spartez.trelloboard.services;

import com.spartez.trelloboard.domain.Task;
import com.spartez.trelloboard.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(final Task task) {
        return taskRepository.save(task);
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElseThrow();
    }

    public List<Task> getTasksByColumn(Long columnId) {
        return taskRepository.findAllByColumnId(columnId);
    }

    public Task updateTask(final Task task) {
        Task taskInDb = taskRepository.findById(task.getId()).orElseThrow();
        taskInDb.setName(task.getName());
        taskInDb.setDescription(task.getDescription());
        return taskRepository.save(taskInDb);
    }

}
