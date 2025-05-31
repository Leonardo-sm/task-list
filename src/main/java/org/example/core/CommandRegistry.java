package org.example.core;

import org.example.core.annotations.Command;
import org.example.core.domain.ICommand;

import java.lang.reflect.Modifier;
import java.util.*;

public class CommandRegistry {
    private static final Map<String, Class<? extends ICommand>> commandMap = new HashMap<>();

    public static void initialize(String packageName) {
        List<Class<?>> annotated = CommandScanner.findCommandsClasses(packageName, Command.class);

        for (Class<?> clazz : annotated) {
            if (!ICommand.class.isAssignableFrom(clazz)) continue;
            if (Modifier.isAbstract(clazz.getModifiers())) continue;

            Command annotation = clazz.getAnnotation(Command.class);
            commandMap.put(annotation.name(), clazz.asSubclass(ICommand.class));
        }
    }

    public static Optional<Class<? extends ICommand>> getCommand(String name) {
        return Optional.ofNullable(commandMap.get(name));
    }
}
