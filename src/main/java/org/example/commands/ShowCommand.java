package org.example.commands;

import org.example.core.annotations.Command;
import org.example.core.domain.CommandBase;
import org.example.core.domain.Task;
import org.example.core.domain.TaskList;

import java.util.Map;

@Command(name = "show", description = "Show all projects and tasks")
public class ShowCommand extends CommandBase {
    @Override
    public void execute() {
        for (Map.Entry<String, TaskList> project : taskState().getTasks().entrySet()) {
            console().getWriter().println(project.getKey());
            for (Task task : project.getValue()) {
                console().getWriter().printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            console().getWriter().println("");
        }
    }
}
