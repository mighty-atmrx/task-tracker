package com.example.tacktracker.service;

import com.example.tacktracker.dto.request.TaskCreateRequest;
import com.example.tacktracker.dto.response.SuccessResponse;
import com.example.tacktracker.dto.response.TaskResponse;
import com.example.tacktracker.dto.request.TaskUpdateRequest;
import com.example.tacktracker.entity.Task;
import com.example.tacktracker.enums.TaskStatus;
import com.example.tacktracker.exception.TaskNotFoundException;
import com.example.tacktracker.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService (TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskResponse> getAll() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(this::getResponse).toList();
    }

    public TaskResponse create(TaskCreateRequest request) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus() != null ? request.getStatus() : TaskStatus.NEW);

        taskRepository.save(task);

        return this.getResponse(task);
    }

    public TaskResponse update(Long id, TaskUpdateRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        task.updateFrom(request);

        taskRepository.save(task);

        return this.getResponse(task);
    }

    public SuccessResponse delete(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        taskRepository.delete(task);
        return new SuccessResponse("Task was deleted successfully.", HttpStatus.OK);
    }

    private TaskResponse getResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus()
        );
    }
}
