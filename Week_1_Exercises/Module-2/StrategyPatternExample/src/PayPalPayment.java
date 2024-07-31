//These are concrete strategy classes that implement the PaymentStrategy interface.
//Each class contains the specific logic for processing payments using different methods (PayPal).

public class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using PayPal.");
        // Add actual PayPal payment processing logic here
    }
}
