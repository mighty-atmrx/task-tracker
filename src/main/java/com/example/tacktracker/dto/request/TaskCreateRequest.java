package com.example.tacktracker.dto.request;

import com.example.tacktracker.enums.TaskStatus;
import jakarta.annotation.Nullable;

public class TaskCreateRequest {
    private String title;

    @Nullable
    private String description;

    private TaskStatus status = TaskStatus.NEW;

    public TaskCreateRequest() {}

    public TaskCreateRequest(String title, @Nullable String description, TaskStatus status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
