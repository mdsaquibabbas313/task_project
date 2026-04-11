package com.project.task.mapper;

import com.project.task.domain.CreateTaskRequest;
import com.project.task.domain.dto.CreateTaskRequestDTO;
import com.project.task.domain.dto.TaskDTO;
import com.project.task.domain.entity.TaskEntity;

public interface TaskMapper {

    CreateTaskRequest toCreateTaskRequestEntity(CreateTaskRequestDTO dto);

    TaskDTO toTaskResponseDTO(TaskEntity entity);



}
