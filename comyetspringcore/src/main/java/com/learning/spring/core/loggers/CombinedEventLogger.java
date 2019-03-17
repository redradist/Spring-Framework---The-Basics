package com.learning.spring.core.loggers;

import com.learning.spring.core.events.Event;

import java.util.List;

public class CombinedEventLogger implements EventLogger {

    private final List<EventLogger> loggers;

    public CombinedEventLogger(final List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (final EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}
