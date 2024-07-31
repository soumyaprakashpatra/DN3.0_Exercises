 // Step 1: Understanding Recursive Algorithms
    // Recursion is a technique where a function calls itself to solve a smaller instance of the problem.
    // It can simplify problems by breaking them down into smaller, more manageable subproblems.
    // Example: Calculating factorial or Fibonacci series.

public class FinancialForecasting {

    public static double calculateFutureValue(double initialValue, double growthRate, int years) {
        // Base case
        if (years == 0) {
            return initialValue;
        }
        // Recursive case: 
        return calculateFutureValue(initialValue * (1 + growthRate), growthRate, years - 1);
    }
    public static void main(String[] args) {
        double initialValue = 1000; 
        double growthRate = 0.05;   
        int years = 10;            
        double futureValue = calculateFutureValue(initialValue, growthRate, years);
        System.out.printf("The future value after %d years is: %.2f%n", years, futureValue);
    }
}
    // Step 4: Analysis
    // Time Complexity:
    // - The recursive algorithm has a time complexity of O(n) because it makes a single recursive call for each year.
    // - Each call performs a constant amount of work besides the recursive call.

    // Optimization:
    // - Memoization: Store results of previous calculations to avoid redundant computations.
    // - Iterative Approach: For better performance, especially for large `years`, consider using an iterative approach instead of recursion.