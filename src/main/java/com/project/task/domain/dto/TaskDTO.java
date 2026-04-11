package com.project.task.domain.dto;

import com.project.task.domain.entity.TaskPriority;
import com.project.task.domain.entity.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

//Response
public record TaskDTO(
        UUID id,
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority,
        TaskStatus status
) {

}
