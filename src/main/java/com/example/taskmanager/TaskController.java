package com.example.taskmanager;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final List<String> tasks = new ArrayList<>();

    @GetMapping
    public List<String> getAllTasks() {
        return tasks;
    }

    @PostMapping
    public String addTask(@RequestBody String task) {
        tasks.add(task);
        return "Task added: " + task;
    }

    @DeleteMapping("/{index}")
    public String deleteTask(@PathVariable int index) {
        if (index < 0 || index >= tasks.size()) {
            return "Invalid task index!";
        }
        String removed = tasks.remove(index);
        return "Task removed: " + removed;
    }
}
