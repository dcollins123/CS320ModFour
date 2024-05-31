package com.taskservice.test;

import com.taskservice.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    void testTaskCreation() {
        Task task = new Task("1", "Task Testing", "Test. Test. This is a test.");
        assertEquals("1", task.getTaskId());
        assertEquals("Task Testing", task.getName());
        assertEquals("Test. Test. This is a test.", task.getDescription());
    }

    @Test
    void testTaskNameUpdate() {
        Task task = new Task("1", "Task Testing", "Test. Test. This is a test.");
        task.setName("Updated Task Testing");
        assertEquals("Updated Task Testing", task.getName());
    }

    @Test
    void testTaskDescriptionUpdate() {
        Task task = new Task("1234567890", "Task Testing", "Test. Test. This is a test.");
        task.setDescription("Updated test description");
        assertEquals("Updated test description", task.getDescription());
    }

    @Test
    void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Task Testing", "Test. Test. This is a test."));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678910", "Task Testing", "Test. Test. This is a test."));
    }

    @Test
    void testInvalidTaskName() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", null, "Test. Test. This is a test."));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "This task name is way too long", "This is a test task description."));
    }

    @Test
    void testInvalidTaskDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "Task Testing", null));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "Task Testing", "Test. Test. This is a test. This is only a test of the emergency broadcast system. BEEP!"));
    }
}
