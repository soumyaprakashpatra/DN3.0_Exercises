//This class tests the Strategy pattern implementation.
//It demonstrates selecting and using different payment strategies (Credit Card and PayPal).

public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        // Pay using Credit Card
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Doe", "123", "12/23");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.pay(250.0);

        System.out.println("");

        // Pay using PayPal
        PaymentStrategy payPalPayment = new PayPalPayment("johndoe@example.com", "password123");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.pay(150.0);
    }
}
