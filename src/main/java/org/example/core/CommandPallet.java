package org.example.core;

import org.example.commands.AddCommand;
import org.example.commands.CheckCommand;
import org.example.commands.HelpCommand;
import org.example.commands.ShowCommand;

import java.util.Arrays;
import java.util.Optional;

public enum CommandPallet {
    ADD("add", "", AddCommand.class),
    SHOW("show", "", ShowCommand.class),
    CHECK("check", "", CheckCommand.class),
    UNCHECK("uncheck", "", CheckCommand.class),
    HELP("help", "", HelpCommand.class);

    private final String commandName;
    private final String description;
    private final Class<? extends Command> commandClass;

    CommandPallet(String commandName, String description, Class<? extends Command> commandCallback) {
        this.commandName = commandName;
        this.description = description;
        this.commandClass = commandCallback;
    }

    public Class<? extends Command> getCommandClass() {
        return commandClass;
    }

    public static Optional<CommandPallet> fromName(String name) {
        return Arrays.stream(values())
                .filter(c -> c.commandName.equalsIgnoreCase(name))
                .findFirst();
    }
}
