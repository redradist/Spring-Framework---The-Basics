package com.learning.spring.core.events;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {
    private static AtomicInteger nextId = new AtomicInteger();

    private int id;
    private String msg;
    private Date date;
    private DateFormat dateFormat;

    public Event(final Date date, final DateFormat dateFormat) {
        this.id = nextId.getAndIncrement();
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }
}
