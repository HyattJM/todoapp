package com.todo.todoapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.todoapp.models.Task;
import com.todo.todoapp.repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}