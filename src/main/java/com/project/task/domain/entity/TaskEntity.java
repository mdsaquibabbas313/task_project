package com.project.task.domain.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    // we don't want to update and put null values in table
    @Column(name = "id" , updatable = false , nullable = false)
    private UUID id;

    @Column(name = "title" , nullable = false)
    private String title;

    // Length up to 1000 only
    @Column(name = "description" , length = 1000)
    private String description;

    @Column(name = "due_date")
    private LocalDate dueDate;

//    save enums as string in db
    @Enumerated(EnumType.STRING)
    @Column(name = "status" , nullable = false)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority" , nullable = false)
    private TaskPriority priority;

    @Column(name = "created" , updatable = false , nullable = false)
    private Instant created;

    @Column(name = "updated" , nullable = false)
    private Instant updated;
}
