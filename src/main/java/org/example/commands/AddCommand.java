package org.example.commands;

import org.example.core.annotations.Command;
import org.example.core.domain.CommandBase;
import org.example.core.domain.TaskList;

@Command(name = "add", description = "project <project name> / add task <project name> <task description>")
public class AddCommand extends CommandBase {
    private final String[] args;

    public AddCommand(String params) {
        this.args = params.split(" ", 3);
    }

    @Override
    public void execute() {
        String sub = args[0];

        switch (sub) {
            case "project" -> addProject(args[1]);
            case "task" -> {
                if (args.length < 3) {
                    console().getWriter().println("Usage: add task <project> <description>");
                    return;
                }
                addTask(args[1], args[2]);
            }
            default -> console().getWriter().println("Unknown subcommand: " + sub);
        }
    }

    private void addProject(String name) {
        taskState().getTasks().putIfAbsent(name, new TaskList());
    }

    private void addTask(String project, String description) {
        var projectTasks = taskState().getTasks().get(project);

        if (projectTasks == null) {
            console().getWriter().printf("Could not find a project with the name \"%s\".", project);
            console().getWriter().println("");
            return;
        }
        projectTasks.addTask(description);
    }
}
