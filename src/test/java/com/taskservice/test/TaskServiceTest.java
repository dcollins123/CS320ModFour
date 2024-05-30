package com.taskservice.test;

import com.taskservice.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    void testAddTask() {
        taskService.addTask("1234567890", "Task 1", "Description 1");
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask("1234567890", "Task 1", "Description 1"));
    }

    @Test
    void testDeleteTask() {
        taskService.addTask("1234567890", "Task 1", "Description 1");
        taskService.deleteTask("1234567890");
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskName("1234567890", "Updated Task Name"));
    }

    @Test
    void testUpdateTaskName() {
        taskService.addTask("1234567890", "Task 1", "Description 1");
        taskService.updateTaskName("1234567890", "Updated Task Name");
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskName("9999999999", "Updated Task Name"));
    }

    @Test
    void testUpdateTaskDescription() {
        taskService.addTask("1234567890", "Task 1", "Description 1");
        taskService.updateTaskDescription("1234567890", "Updated Task Description");
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskDescription("9999999999", "Updated Task Description"));
    }
}
