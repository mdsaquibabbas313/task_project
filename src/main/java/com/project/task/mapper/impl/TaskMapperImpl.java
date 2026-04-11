package com.project.task.mapper.impl;

import com.project.task.domain.CreateTaskRequest;
import com.project.task.domain.dto.CreateTaskRequestDTO;
import com.project.task.domain.dto.TaskDTO;
import com.project.task.domain.entity.TaskEntity;
import com.project.task.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public CreateTaskRequest toCreateTaskRequestEntity(CreateTaskRequestDTO dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority()
        );
    }

    @Override
    public TaskDTO toTaskResponseDTO(TaskEntity entity) {
        return new TaskDTO(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getDueDate(),
                entity.getPriority(),
                entity.getStatus()
        );
    }
}
