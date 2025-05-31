package org.example.commands;

import org.example.core.domain.CommandBase;

public class HelpICommand extends CommandBase {
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
