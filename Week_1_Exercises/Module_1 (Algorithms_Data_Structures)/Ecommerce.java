// ### 1. Understand Asymptotic Notation

// **Big O Notation:**

// - **Definition:** Describes the upper bound of an algorithm's running time, indicating the worst-case scenario as input size grows.
// - **Purpose:** Helps understand algorithm scalability and compare performance.

// **Search Operation Scenarios:**

// - **Best Case:** Fastest scenario (e.g., finding the first element).
// - **Average Case:** Expected time considering all cases.
// - **Worst Case:** Slowest scenario (e.g., element not found).

// ### Setup
import java.util.Arrays;
import java.util.Comparator;

class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

// Define the Ecommerce class with search functionalities
public class Ecommerce {

    public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String productName) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName));
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = products[mid].getProductName().compareTo(productName);

            if (result == 0) {
                return products[mid];
            }
            if (result < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
// ### Implementation
    public static void main(String[] args) {
        Product[] products = {
                new Product("001", "Laptop", "Electronics"),
                new Product("002", "Smartphone", "Electronics"),
                new Product("003", "Tablet", "Electronics"),
                new Product("004", "Smartwatch", "Electronics"),
                new Product("005", "Camera", "Electronics")
        };

        // Linear search test
        Product result1 = linearSearch(products, "Tablet");
        System.out.println("Linear Search Result: " + result1);

        // Binary search test
        Product result2 = binarySearch(products, "Smartwatch");
        System.out.println("Binary Search Result: " + result2);
    }
}
