package org.example.core.domain;


import java.util.ArrayList;

public class TaskList extends ArrayList<Task> {
    private int nextId = 0;

    public void addTask(String description) {
        super.add(new Task(nextId(), description, false));
    }

    private int nextId() {
        return ++nextId;
    }
}
