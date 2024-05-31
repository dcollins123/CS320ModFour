package com.taskservice;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private Map<String, Task> tasks = new HashMap<>();

    public void addTask(String taskId, String name, String description) {
        if (tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID already exists");
        }
        tasks.put(taskId, new Task(taskId, name, description));
    }

    public void deleteTask(String taskId) {
        tasks.remove(taskId);
    }

    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }

    public void updateTaskName(String taskId, String newName) {
        Task task = tasks.get(taskId);
        if (task != null) {
            task.setName(newName);
        } else {
            throw new IllegalArgumentException("Task ID not found");
        }
    }

    public void updateTaskDescription(String taskId, String newDescription) {
        Task task = tasks.get(taskId);
        if (task != null) {
            task.setDescription(newDescription);
        } else {
            throw new IllegalArgumentException("Task ID not found");
        }
    }
}
