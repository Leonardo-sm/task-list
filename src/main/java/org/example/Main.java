package org.example;

import org.example.core.CommandFactory;
import org.example.core.CommandRegistry;
import org.example.core.CommandScanner;
import org.example.core.TaskListRunner;
import org.example.core.domain.ICommand;
import org.example.core.annotations.Command;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        TaskListRunner.run(reader, writer);
    }
}