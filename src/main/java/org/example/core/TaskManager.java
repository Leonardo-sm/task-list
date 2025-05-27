package org.example.core;

import org.example.Task;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {
    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    private int idCounter = 1;

    public void addProject(String name) {
        tasks.put(name, new ArrayList<>());
    }

    public boolean hasProject(String name) {
        return tasks.containsKey(name);
    }

    public void addTask(String project, String task) {
        tasks.get(project).add(new Task(nextId(), task, false));
    }

    public List<Task> getTasks(String project) {
        return tasks.getOrDefault(project, List.of());
    }

    private int nextId() {
        return idCounter++;
    }
}
