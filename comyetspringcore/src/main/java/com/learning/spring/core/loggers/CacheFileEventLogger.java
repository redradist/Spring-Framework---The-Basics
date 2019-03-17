package com.learning.spring.core.loggers;

import com.learning.spring.core.events.Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private List<Event> cache = new ArrayList<>();
    private int cacheSize;

    CacheFileEventLogger(final String fileName,
                         final int cacheSize) {
        super(fileName);

        this.cacheSize = cacheSize;
    }

    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        for (final Event event : cache) {
            logEvent(event);
        }
    }

    void destroy() throws IOException {
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }
}
