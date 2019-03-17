package com.learning.spring.core.loggers;

import com.learning.spring.core.events.Event;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file = null;

    public FileEventLogger(final String fileName) {
        this.fileName = fileName;
    }

    void init() throws IOException {
        this.file = new File(fileName);
        if (this.file.exists() && !this.file.canWrite()) {
            throw new IOException(String.format("file: %s, - is not writable !!", fileName));
        } else if (!this.file.exists()) {
            this.file.createNewFile();
        }
    }

    public void logEvent(Event event) {
        final File logFile = new File(fileName);
    }
}
