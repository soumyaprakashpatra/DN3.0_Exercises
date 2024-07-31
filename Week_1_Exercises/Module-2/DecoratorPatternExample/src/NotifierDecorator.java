//This is an abstract decorator class that implements the `Notifier` interface and holds a reference to a `Notifier` object. 
//It delegates the `send` method call to the wrapped notifier.

public abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}
