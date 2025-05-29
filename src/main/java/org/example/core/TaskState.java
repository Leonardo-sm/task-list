package org.example.core;

import org.example.core.domain.Task;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TaskState {
    public static final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    public static int nextId = 0;

    public static long nextId() {
        return ++nextId;
    }
}
