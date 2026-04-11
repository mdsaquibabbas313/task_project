package com.project.task.controller;

import com.project.task.domain.CreateTaskRequest;
import com.project.task.domain.dto.CreateTaskRequestDTO;
import com.project.task.domain.dto.TaskDTO;
import com.project.task.domain.entity.TaskEntity;
import com.project.task.mapper.TaskMapper;
import com.project.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;


    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(
            @Valid @RequestBody CreateTaskRequestDTO createTaskRequestDTO
    ) {
        CreateTaskRequest createTaskRequest =
                taskMapper.toCreateTaskRequestEntity(createTaskRequestDTO);

        TaskEntity taskEntity = taskService.createTask(createTaskRequest);
        TaskDTO createdTaskDTO = taskMapper.toTaskResponseDTO(taskEntity);

        return new ResponseEntity<>(createdTaskDTO, HttpStatus.CREATED);


    }
    @GetMapping
    public ResponseEntity<List<TaskDTO>> listTasks() {
        List<TaskEntity> tasks = taskService.listTasks();
        List<TaskDTO> taskDtos = tasks.stream()
                .map(taskMapper::toTaskResponseDTO).toList();
        return ResponseEntity.ok(taskDtos);
    }



}


