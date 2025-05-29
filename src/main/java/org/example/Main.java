package org.example;

import org.example.core.CommandScanner;
import org.example.core.TaskListRunner;
import org.example.core.annotations.Commands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        List<Class<?>> commands = CommandScanner.findCommandsClasses("org.example.commands", Commands.class);

        for (var cmd : commands) {
            System.out.println("Classe anotada encontrada: " + cmd.getName());
        }

//        TaskListRunner.run(reader, writer);
    }
}