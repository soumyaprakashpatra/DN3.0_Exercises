//The Logger class should has a private static instance of itself.
//The constructor should be private to prevent direct instantiation.
//The `getInstance()` method provides a way to get the single instance of the class. 
//It should use the double-checked locking to ensure thread safety and lazy initialization.

public class logger {
    // Step 2.1: Create a private static instance of Logger
    private static logger instance;

    // Step 2.2: Ensure the constructor of Logger is private
    private logger() {
        // Private constructor to prevent instantiation
    }

    // Step 2.3: Provide a public static method to get the instance of Logger
    public static logger getInstance() {
        if (instance == null) {
            synchronized (logger.class) {
                if (instance == null) {
                    instance = new logger();
                }
            }
        }
        return instance;
    }

    // Example method to log messages
    public void log(String message) {
        System.out.println(message);
    }
}
