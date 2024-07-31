//This is the strategy interface with a `pay(double amount)` method that all payment strategies must implement.

public interface PaymentStrategy {
    void pay(double amount);
}
