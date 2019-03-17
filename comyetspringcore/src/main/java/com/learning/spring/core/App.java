package com.learning.spring.core;

import com.learning.spring.core.beans.Client;
import com.learning.spring.core.events.Event;
import com.learning.spring.core.loggers.ConsoleEventLogger;
import com.learning.spring.core.loggers.EventLogger;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private EventLogger eventLogger;

    private App(final Client client, final EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    void logEvent(final Event event) {
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) applicationContext.getBean("app");
        Event evt0 = (Event) applicationContext.getBean("event");
        app.logEvent(evt0);
        Event evt1 = (Event) applicationContext.getBean("event");
        app.logEvent(evt1);
    }
}
