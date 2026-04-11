package com.project.task.service;

import com.project.task.domain.CreateTaskRequest;
import com.project.task.domain.entity.TaskEntity;

import java.util.List;

public interface TaskService {

    TaskEntity createTask(CreateTaskRequest request);

    List<TaskEntity> listTasks();

}
