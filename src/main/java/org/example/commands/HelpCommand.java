package org.example.commands;

import org.example.core.Command;

public class HelpCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Commands:");
        System.out.println("  show");
        System.out.println("  add project <project name>");
        System.out.println("  add task <project name> <task description>");
        System.out.println("  check <task ID>");
        System.out.println("  uncheck <task ID>");
        System.out.println();
    }
}
