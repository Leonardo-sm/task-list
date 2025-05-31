package org.example.commands;

import org.example.core.domain.CommandBase;
import org.example.core.domain.Task;
import org.example.core.domain.TaskList;

import java.util.Map;

public class ShowICommand extends CommandBase {
    @Override
    public void execute() {
        for (Map.Entry<String, TaskList> project : taskState().getTasks().entrySet()) {
            System.out.println(project.getKey());
            for (Task task : project.getValue()) {
                System.out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            System.out.println();
        }
    }
}
