package org.example.core;

import org.example.core.domain.ICommand;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CommandFactory {
    public static Optional<ICommand> createCommand(Class<? extends ICommand> cmdEnum, List<String> args) {
        return Arrays.stream(cmdEnum.getConstructors())
                .filter(ctor -> ctor.getParameterCount() == args.size())
                .filter(ctor -> Arrays.stream(ctor.getParameterTypes()).allMatch(t -> t == String.class))
                .findFirst()
                .flatMap(ctor -> {
                    try {
                        return Optional.of((ICommand) ctor.newInstance(args.toArray()));
                    } catch (Exception e) {
                        return Optional.empty();
                    }
                });
    }
}
