package org.example.core;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CommandFactory {
    public static Optional<Command> createCommand(CommandPallet cmdEnum, List<String> args) {
//        try {
//            for (Constructor<?> ctor : cmdEnum.getCommandClass().getConstructors()) {
//                if (ctor.getParameterCount() != args.size()) continue;
//
//                if (Arrays.stream(ctor.getParameterTypes()).allMatch(t -> t == String.class)) {
//                    return Optional.of((Command) ctor.newInstance(args.toArray()));
//                }
//            }
//            return Optional.empty();
//        } catch (Exception e) {
//            return Optional.empty();
//        }

        return Arrays.stream(cmdEnum.getCommandClass().getConstructors())
                .filter(ctor -> ctor.getParameterCount() == args.size())
                .filter(ctor -> Arrays.stream(ctor.getParameterTypes()).allMatch(t -> t == String.class))
                .findFirst()
                .flatMap(ctor -> {
                    try {
                        return Optional.of((Command) ctor.newInstance(args.toArray()));
                    } catch (Exception e) {
                        return Optional.empty();
                    }
                });
    }
}
