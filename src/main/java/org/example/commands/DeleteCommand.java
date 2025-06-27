package org.example.commands;

import org.example.core.annotations.Command;
import org.example.core.domain.CommandBase;

@Command(name = "delete", description = "delete <task ID>")
public class DeleteCommand extends CommandBase {
    private final String[] args;

    public DeleteCommand(String params) {
        this.args = params.split(" ", 2);
    }

    @Override
    public void execute() {
        String sub = args[0];

        switch (sub) {
            case "project" -> deleteProject(args[1]);
            case "task" -> deleteTask(args[1]);
            default -> console().getWriter().println("Unknown subcommand: " + sub);
        }
    }

    private void deleteProject(String project) {
        var removed = taskState().getTasks().remove(project);
        if (removed == null) {
            console().getWriter().printf("Project with name: %s not found\n", project);
        }
    }

    private void deleteTask(String id) {
        taskState().getTasks().values().forEach(taskList -> {
            var removed = taskList.removeIf(task -> task.getId() == Integer.parseInt(id));
            if (!removed) {
                console().getWriter().printf("Task with id: %s not found\n", id);
            }
        });
    }
    
}
