package com.learning.spring.core;

import com.learning.spring.core.beans.Client;
import com.learning.spring.core.events.Event;
import com.learning.spring.core.events.EventType;
import com.learning.spring.core.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    private Client client;
    private EventLogger defaultLogger;
    private final Map<EventType, EventLogger> loggers;

    public App(final Client client,
               final EventLogger eventLogger,
               final Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    public void logEvent(final EventType type, final Event event) {
        EventLogger logger = loggers.get(type);
        if (logger == null) {
            logger = defaultLogger;
        }
        logger.logEvent(event);
    }

    public static void main(String[] args) {
        try (final ConfigurableApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring.xml")) {
            App app = (App) applicationContext.getBean("app");
            Event evt0 = (Event) applicationContext.getBean("event");
            app.logEvent(EventType.INFO, evt0);
            Event evt1 = (Event) applicationContext.getBean("event");
            app.logEvent(EventType.ERROR, evt1);
            Event evt2 = (Event) applicationContext.getBean("event");
            app.logEvent(EventType.DEBUG, evt1);
        }
    }
}
