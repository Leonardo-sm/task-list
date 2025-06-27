package org.example.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskApplicationRun implements Runnable {
    private static final String QUIT = "quit";

    private BufferedReader reader;
    private PrintWriter writer;

    public TaskApplicationRun(BufferedReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void run() {
        ConsoleContext.initialize(reader, writer);
        
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

    private void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];

        CommandRegistry commandRegistry = new CommandRegistry();

        if (commandRest.length > 1) {
            CommandExecutor.run(commandRegistry, command, commandRest[1]);
        } else {
            CommandExecutor.run(commandRegistry, command);
        }
    }
}
