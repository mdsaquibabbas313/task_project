package com.project.task.service.impl;

import com.project.task.domain.CreateTaskRequest;
import com.project.task.domain.entity.TaskEntity;
import com.project.task.domain.entity.TaskStatus;
import com.project.task.repository.TaskRepository;
import com.project.task.service.TaskService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskEntity createTask(CreateTaskRequest request) {

        Instant now = Instant.now();

        TaskEntity taskEntity = new TaskEntity(
                null,
                request.title(),
                request.description(),
                request.dueDate(),
                TaskStatus.OPEN,
                request.priority(),
                now,
                now
        );

        return
                taskRepository.save(taskEntity);

    }

    @Override
    public List<TaskEntity> listTasks() {
        return taskRepository.findAll(Sort.by(Sort.Direction.ASC , "created"));
    }
}
