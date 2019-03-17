package com.learning.spring.core.loggers;

public class ConsoleEventLogger implements EventLogger {
    public void logEvent(final String msg) {
        System.out.println(msg);
    }
}
