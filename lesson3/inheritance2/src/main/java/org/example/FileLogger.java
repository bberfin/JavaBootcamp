package org.example;

public class FileLogger extends Logger {
    @Override
    public void log() {
        System.out.println("logged to file");
    }
}
