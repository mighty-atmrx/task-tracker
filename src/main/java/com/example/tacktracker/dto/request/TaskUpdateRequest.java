package com.example.tacktracker.dto.request;

import com.example.tacktracker.enums.TaskStatus;
import jakarta.annotation.Nullable;

public class TaskUpdateRequest {
    @Nullable
    private String title;

    @Nullable
    private String description;

    @Nullable
    private TaskStatus status = TaskStatus.NEW;

    public TaskUpdateRequest() {}

    public TaskUpdateRequest(@Nullable String title, @Nullable String description, @Nullable TaskStatus status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    @Nullable
    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(@Nullable TaskStatus status) {
        this.status = status;
    }
}
