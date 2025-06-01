package org.example.core;

import org.example.core.domain.ICommand;
import org.example.helpers.ErrorMessage;

import java.util.List;

public class CommandExecutor {
    public static void run(CommandRegistry commands, String commandName, String... args) {
        commands.getCommand(commandName)
                .flatMap(cmdEnum -> CommandFactory.createCommand(cmdEnum, List.of(args)))
                .ifPresentOrElse(
                        ICommand::execute,
                        () -> System.out.print(ErrorMessage.getMessage(commandName, args))
                );
    }
}
