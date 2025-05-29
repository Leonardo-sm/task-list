package org.example.helpers;

import java.util.Arrays;

public class ErrorMessage {
    private static final String errorMessage = "Comando \"%s\" inválido ou parâmetros incorretos. \n";
    private static final String errorMessageWithArgs = "Comando \"%s\" inválido ou parâmetros \"%s\" incorretos. \n";

    public static String getMessage(String commandName, String... args) {
        if (Arrays.stream(args).findAny().isPresent()) {
            return String.format(errorMessageWithArgs, commandName, argsToString(args));
        }
        return String.format(errorMessage, commandName);
    }

    private static String argsToString(String[] args) {
        return String.join(", ", args);
    }

}
