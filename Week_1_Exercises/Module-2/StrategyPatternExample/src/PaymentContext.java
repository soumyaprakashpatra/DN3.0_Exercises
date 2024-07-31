//This is the context class that holds a reference to a `PaymentStrategy` object.
//It has a `setPaymentStrategy(PaymentStrategy paymentStrategy)` method to set the strategy at runtime.
//The `pay(double amount)` method executes the current payment strategy.

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set.");
        }
        paymentStrategy.pay(amount);
    }
}
