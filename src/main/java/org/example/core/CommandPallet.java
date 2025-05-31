package org.example.core;

import org.example.commands.AddICommand;
import org.example.commands.CheckICommand;
import org.example.commands.HelpICommand;
import org.example.commands.ShowICommand;
import org.example.core.domain.ICommand;

import java.util.Arrays;
import java.util.Optional;

public enum CommandPallet {
    ADD("add", "", AddICommand.class),
    SHOW("show", "", ShowICommand.class),
    CHECK("check", "", CheckICommand.class),
    UNCHECK("uncheck", "", CheckICommand.class),
    HELP("help", "", HelpICommand.class);

    private final String commandName;
    private final String description;
    private final Class<? extends ICommand> commandClass;

    CommandPallet(String commandName, String description, Class<? extends ICommand> commandCallback) {
        this.commandName = commandName;
        this.description = description;
        this.commandClass = commandCallback;
    }

    public Class<? extends ICommand> getCommandClass() {
        return commandClass;
    }

    public static Optional<CommandPallet> fromName(String name) {
        return Arrays.stream(values())
                .filter(c -> c.commandName.equalsIgnoreCase(name))
                .findFirst();
    }
}
