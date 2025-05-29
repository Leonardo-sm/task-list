package org.example.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TaskListRunner {
    private static final String QUIT = "quit";

    public static void run(BufferedReader reader, PrintWriter writer) {
        while (true) {
            writer.print("> ");
            writer.flush();
            String command;
            try {
                command = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            execute(command);
        }
    }

    private static void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];

        if (commandRest.length > 1) {
            CommandExecutor.run(command, commandRest[1]);
        } else {
            CommandExecutor.run(command);
        }

    }
}
