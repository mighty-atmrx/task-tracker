package com.example.tacktracker.repository;

import com.example.tacktracker.entity.Task;
import com.example.tacktracker.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(@Param("status") TaskStatus status);
}
