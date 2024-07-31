//This class tests the Singleton implementation.
//It retrieves the instance of Logger multiple times and logs messages to verify that the same instance is used throughout the application.
//It checks if both logger1 and logger2 refer to the same instance.

public class singletonTest {
    public static void main(String[] args) {
        // Retrieve the single instance of Logger
        logger logger1 = logger.getInstance();
        logger logger2 = logger.getInstance();

        // Log messages using the logger instance
        logger1.log("Logging from logger1 instance");
        logger2.log("Logging from logger2 instance");

        // Verify that both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are created by the same instance 'logger'.");
        } else {
            System.out.println("logger1 and logger2 are different instances.");
        }
    }
}
