package com.example.tacktracker.dto.response;

import com.example.tacktracker.enums.TaskStatus;

public record TaskResponse(
        Long id,
        String title,
        String description,
        TaskStatus status
) {}
