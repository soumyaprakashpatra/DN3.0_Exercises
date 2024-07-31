//These are concrete strategy classes that implement the PaymentStrategy interface.
//Each class contains the specific logic for processing payments using different methods (for Credit Card).

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String cardExpiry;
    private String cardCVV;

    public CreditCardPayment(String cardNumber, String cardHolderName, String cardExpiry, String cardCVV) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cardExpiry = cardExpiry;
        this.cardCVV = cardCVV;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
        // Implement actual payment processing logic here
        
    }
}
