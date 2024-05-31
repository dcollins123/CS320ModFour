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
    void addTaskTest() {
        taskService.addTask("1", "Task Testing", "Test. Test. This is a test.");
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask("1", "Task Testing", "Test. Test. This is a test."));
    }

    @Test
    void deleteTaskTest() {
        taskService.addTask("1", "Task Testing", "Test. Test. This is a test.");
        taskService.deleteTask("1");
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskName("1", "Updated Task Testing"));
    }

    @Test
    void updateTaskNameTest() {
        taskService.addTask("1", "Task Testing", "Test. Test. This is a test.");
        taskService.updateTaskName("1", "Updated Task Testing");
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskName("2", "Updated Task Testing"));
    }

    @Test
    void updateTaskDescriptionTest() {
        taskService.addTask("1", "Task Testing", "Test. Test. This is a test.");
        taskService.updateTaskDescription("1", "Updated test description");
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskDescription("2", "Updated test description"));
    }
}
