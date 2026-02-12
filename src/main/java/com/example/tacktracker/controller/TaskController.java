package com.example.tacktracker.controller;

import com.example.tacktracker.dto.request.TaskCreateRequest;
import com.example.tacktracker.dto.response.SuccessResponse;
import com.example.tacktracker.dto.response.TaskResponse;
import com.example.tacktracker.dto.request.TaskUpdateRequest;
import com.example.tacktracker.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskResponse> getAll() {
        return taskService.getAll();
    }

    @PostMapping
    public TaskResponse create(@RequestBody TaskCreateRequest request) {
        return taskService.create(request);
    }

    @PatchMapping("/{id}")
    public TaskResponse update(@PathVariable Long id, @RequestBody TaskUpdateRequest request) {
        return taskService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public SuccessResponse delete(@PathVariable Long id) {
        return taskService.delete(id);
    }
}
