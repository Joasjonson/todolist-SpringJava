package com.joas.todo.Service;

import com.joas.todo.Exceptions.MissingStatusException;
import com.joas.todo.Exceptions.TaskNotFoundException;
import com.joas.todo.Exceptions.StatusNotFoundException;
import com.joas.todo.Model.Status;
import com.joas.todo.Model.Task;
import com.joas.todo.Repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }
    
    public Task saveTask(Task task){
        return repository.save(task);
    }

    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    public Task getTaskById(Long id) {
        return repository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
    }

    public List<Task> getTasksByStatus(String status) {
        if (status == null || status.isBlank()) {
            throw new MissingStatusException("Status parameter is missing");
        }

        Status parsed;
        try {
            parsed = Status.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new StatusNotFoundException("Invalid status: " + status);}

        return repository.findByStatus(parsed);
    }

    public void deleteTask(Long id){
        Task task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
        repository.delete(task);
    }

    public void updateTask(Task task, Long id){
        Task existingTask = repository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));

        Task updatedTask = Task.builder()
                .id(existingTask.getId())
                .title(task.getTitle() != null ? task.getTitle() : existingTask.getTitle())
                .description(task.getDescription() != null ? task.getDescription() : existingTask.getDescription())
                .status(task.getStatus() != null ? task.getStatus() : existingTask.getStatus())
                .build();

        repository.save(updatedTask);
    }

}
