package org.example.core;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class ConsoleContext {
    private static ConsoleContext instance;
    
    private final BufferedReader reader;
    private final PrintWriter writer;
    
    private ConsoleContext(BufferedReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }
    
    public static void initialize(BufferedReader reader, PrintWriter writer) {
        instance = new ConsoleContext(reader, writer);
    }
    
    public static ConsoleContext getInstance() {
        if (instance == null) {
            throw new IllegalStateException("ConsoleContext not initialized. Call initialize() first.");
        }
        return instance;
    }
    
    public BufferedReader getReader() {
        return reader;
    }
    
    public PrintWriter getWriter() {
        return writer;
    }
} 