public class App {
    private Client client;
    private ConsoleEventLogger eventLogger;

    void logEvent(final String msg) {
        final String message = msg.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(message);
    }

    public static void main(String[] args) {
        App app = new App();

        app.client = new Client("1", "John Smith");
        app.eventLogger = new ConsoleEventLogger();

        app.logEvent("Some event for use 1");
    }
}
