package org.example.commands;

import org.example.core.CommandRegistry;
import org.example.core.annotations.Command;
import org.example.core.domain.CommandBase;

@Command(name = "help", description = "List all available commands")
public class HelpCommand extends CommandBase {
    @Override
    public void execute() {
        CommandRegistry commandRegistry = new CommandRegistry();
        var commandsInfo = commandRegistry.getCommandInfo();

        console().getWriter().println("Available Commands:");
        for (var info : commandsInfo.entrySet()) {
           console().getWriter().printf(" %-5s - %s%n", info.getKey(), info.getValue());
        }
    }
}
