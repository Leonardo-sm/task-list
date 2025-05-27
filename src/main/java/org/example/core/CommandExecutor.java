package org.example.core;

import java.util.List;

public class CommandExecutor {
    public static void run(String commandName, String... args) {
        CommandPallet.fromName(commandName)
                .flatMap(cmdEnum -> CommandFactory.createCommand(cmdEnum, List.of(args)))
                .ifPresentOrElse(
                        Command::execute,
                        () -> System.out.println("Comando inválido ou parâmetros incorretos.")
                );
    }
}
