package org.example.core;

import org.example.helpers.ErrorMessage;

import java.util.List;

public class CommandExecutor {
    public static void run(String commandName, String... args) {
        CommandPallet.fromName(commandName)
                .flatMap(cmdEnum -> CommandFactory.createCommand(cmdEnum, List.of(args)))
                .ifPresentOrElse(
                        Command::execute,
                        () -> System.out.print(ErrorMessage.getMessage(commandName, args))
                );
    }
}
