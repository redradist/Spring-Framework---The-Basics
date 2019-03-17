package com.learning.spring.core.loggers;

import com.learning.spring.core.events.Event;

public class ConsoleEventLogger implements EventLogger {
    public void logEvent(final Event msg) {
        System.out.println(msg);
    }
}
