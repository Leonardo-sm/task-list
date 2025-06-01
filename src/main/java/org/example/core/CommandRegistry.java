package org.example.core;

import org.example.core.annotations.Command;
import org.example.core.domain.ICommand;

import java.lang.reflect.Modifier;
import java.util.*;

public class CommandRegistry {
    private static final String commandsDefaultPackagePath = "org.example.commands";
    private final Map<String, Class<? extends ICommand>> commandMap = new HashMap<>();
    private final Map<String, String> commandInfo = new HashMap<>();

    public CommandRegistry() {
        this(CommandScanner.findCommandsClasses(commandsDefaultPackagePath, Command.class));
    }

    public CommandRegistry(List<Class<?>> commands) {
        loadCommands(commands);
    }

    public Optional<Class<? extends ICommand>> getCommand(String name) {
        return Optional.ofNullable(commandMap.get(name));
    }

    public Map<String, String> getCommandInfo() {
        return commandInfo;
    }

    private void loadCommands(List<Class<?>> commands) {
        for (Class<?> clazz : commands) {
            if (!ICommand.class.isAssignableFrom(clazz)) continue;
            if (Modifier.isAbstract(clazz.getModifiers())) continue;

            Command annotation = clazz.getAnnotation(Command.class);
            commandMap.put(annotation.name(), clazz.asSubclass(ICommand.class));
            commandInfo.put(annotation.name(), annotation.description());
        }
    }
}
