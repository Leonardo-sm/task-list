package org.example.core;

import org.example.core.annotations.Command;
import org.example.core.domain.ICommand;

import java.lang.reflect.Modifier;
import java.util.*;

public class CommandRegistry {
    private final Map<String, Class<? extends ICommand>> commandMap = new HashMap<>();

    public CommandRegistry(List<Class<?>> commands) {
        loadCommands(commands);
    }

    public Optional<Class<? extends ICommand>> getCommand(String name) {
        return Optional.ofNullable(commandMap.get(name));
    }

    private void loadCommands(List<Class<?>> commands) {
        for (Class<?> clazz : commands) {
            if (!ICommand.class.isAssignableFrom(clazz)) continue;
            if (Modifier.isAbstract(clazz.getModifiers())) continue;

            Command annotation = clazz.getAnnotation(Command.class);
            commandMap.put(annotation.name(), clazz.asSubclass(ICommand.class));
        }
    }
}
