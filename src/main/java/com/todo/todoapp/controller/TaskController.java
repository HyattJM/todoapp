package com.todo.todoapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.todo.todoapp.models.Task;
import com.todo.todoapp.service.TaskService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// @RequestMapping
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @GetMapping
    public String getTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks"; // Return the view name to render tasks
    }

    @PostMapping
    public String createTask(@RequestParam String title) {
        taskService.createTask(title);
        return "redirect:/"; // Return the view name to render tasks
    }

    @GetMapping("/{id}/delete")
        public String deleteTasks(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/"; // Return the view name to render tasks
    }

     @GetMapping("/{id}/toggle")
        public String toggleTasks(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/"; // Return the view name to render tasks
    }

    // Define endpoints for handling tasks here
    // e.g., createTask, getTasks, updateTask, deleteTask, etc.
}