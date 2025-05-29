package org.example.commands;

import org.example.core.annotations.Commands;
import org.example.core.domain.Task;
import org.example.core.Command;
import org.example.core.TaskState;

import java.util.ArrayList;
import java.util.List;

@Commands
public class AddCommand implements Command {
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
                    System.out.println("Usage: add task <project> <description>");
                    return;
                }
                addTask(args[1], args[2]);
            }
            default -> System.out.println("Unknown subcommand: " + sub);
        }
    }

    private void addProject(String name) {
        TaskState.tasks.putIfAbsent(name, new ArrayList<Task>());
    }

    private void addTask(String project, String description) {
        List<Task> projectTasks = TaskState.tasks.get(project);

        if (projectTasks == null) {
            System.out.printf("Could not find a project with the name \"%s\".", project);
            System.out.println();
            return;
        }
        projectTasks.add(new Task(TaskState.nextId(), description, false));
    }
}
