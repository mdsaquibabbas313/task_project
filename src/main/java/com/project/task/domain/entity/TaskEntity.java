package com.project.task.domain.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;
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

    public TaskEntity() {
    }

    public TaskEntity(UUID id, String title, String description, LocalDate dueDate, TaskStatus status, TaskPriority priority, Instant created, Instant updated) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
        this.created = created;
        this.updated = updated;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskEntity that = (TaskEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", status=" + status +
                ", priority=" + priority +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

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
