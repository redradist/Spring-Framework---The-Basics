package com.learning.spring.core;

import com.learning.spring.core.beans.Client;
import com.learning.spring.core.loggers.ConsoleEventLogger;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private ConsoleEventLogger eventLogger;

    private App(final Client client, final ConsoleEventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    void logEvent(final String msg) {
        final String message = msg.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(message);
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) applicationContext.getBean("app");
        app.logEvent("Some event for use 1");
    }
}
