package org.example.core.domain;

import java.util.ArrayList;

public class TaskList extends ArrayList<Task> {
    private static int nextId = 0;

    public void addTask(String description) {
        super.add(new Task(getNextId(), description, false));
    }

    private static int getNextId() {
        return ++nextId;
    }
}
