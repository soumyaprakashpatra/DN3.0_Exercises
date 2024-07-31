//This is a concrete component class that implements the `Notifier` interface and sends notifications via email.

public class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}
