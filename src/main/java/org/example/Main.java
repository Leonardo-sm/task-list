package org.example;

import org.example.core.TaskApplicationRun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        TaskApplicationRun taskApplicationRun = new TaskApplicationRun(reader, writer);

        taskApplicationRun.run();
    }
}