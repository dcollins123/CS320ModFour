package com.taskservice.test;

import com.taskservice.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    void testTaskCreation() {
        Task task = new Task("1234567890", "Test Task", "This is a test task description.");
        assertEquals("1234567890", task.getTaskId());
        assertEquals("Test Task", task.getName());
        assertEquals("This is a test task description.", task.getDescription());
    }

    @Test
    void testTaskNameUpdate() {
        Task task = new Task("1234567890", "Test Task", "This is a test task description.");
        task.setName("Updated Task Name");
        assertEquals("Updated Task Name", task.getName());
    }

    @Test
    void testTaskDescriptionUpdate() {
        Task task = new Task("1234567890", "Test Task", "This is a test task description.");
        task.setDescription("Updated Task Description");
        assertEquals("Updated Task Description", task.getDescription());
    }

    @Test
    void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Test Task", "This is a test task description."));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Test Task", "This is a test task description."));
    }

    @Test
    void testInvalidTaskName() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", null, "This is a test task description."));
        assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", "This task name is way too long", "This is a test task description."));
    }

    @Test
    void testInvalidTaskDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", "Test Task", null));
        assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", "Test Task", "This task description is way too long and exceeds the fifty character limit."));
    }
}
