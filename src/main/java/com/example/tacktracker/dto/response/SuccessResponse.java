package com.example.tacktracker.dto.response;

import org.springframework.http.HttpStatus;

public record SuccessResponse(
        String message,
        HttpStatus status
) {}
