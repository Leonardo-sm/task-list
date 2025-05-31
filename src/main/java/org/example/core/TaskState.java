package org.example.core;

import org.example.core.domain.TaskList;

import java.util.*;

public class TaskState {
    private static final TaskState INSTANCE = new TaskState();

    private final Map<String, TaskList> tasks = new LinkedHashMap<>();

    private TaskState() {}

    public static TaskState getInstance() {
        return INSTANCE;
    }

    public Map<String, TaskList> getTasks() {
        return tasks;
    }
}
