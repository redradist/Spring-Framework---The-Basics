package com.learning.spring.core.loggers;

import com.learning.spring.core.events.Event;

public interface EventLogger {
    void logEvent(final Event event);
}
