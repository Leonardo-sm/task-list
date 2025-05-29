package org.example.commands;

import org.example.core.domain.Task;
import org.example.core.Command;
import org.example.core.TaskState;

import java.util.List;
import java.util.Map;

public class ShowCommand implements Command {
    @Override
    public void execute() {
        for (Map.Entry<String, List<Task>> project : TaskState.tasks.entrySet()) {
            System.out.println(project.getKey());
            for (Task task : project.getValue()) {
                System.out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            System.out.println();
        }
    }
}
