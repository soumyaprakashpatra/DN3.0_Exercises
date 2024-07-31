// Why Data Structures and Algorithms are Essential in Handling Large Inventories?

// 1. **Efficient Data Storage and Retrieval:** Ensures quick access, insertion, and deletion operations.
// 2. **Scalability:** Maintains performance as the inventory size increases.
// 3. **Memory Management:** Optimizes memory usage to handle large datasets.
// 4. **Data Integrity and Consistency:** Ensures reliable updates and operations.
// 5. **Fast Search Operations:** Provides quick search capabilities, crucial for large inventories.
// 6. **Handling Concurrent Operations:** Supports multiple users accessing and modifying the inventory simultaneously.
import java.util.HashMap;

// Define the Product class
class Product1 {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product1(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

// Define the InventoryManagementSystem class
public class InventoryManagementSystem {
    private HashMap<String, Product1> inventory;

    public InventoryManagementSystem() {
        this.inventory = new HashMap<>();
    }

    // Add product
    public void addProduct(Product1 product) {
        inventory.put(product.getProductId(), product);
    }

    // Update product
    public void updateProduct(String productId, Product1 updatedProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, updatedProduct);
        } else {
            System.out.println("Product not found!");
        }
    }

    // Delete product
    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found!");
        }
    }

    // Retrieve product details
    public Product1 getProduct(String productId) {
        return inventory.get(productId);
    }

    // Main method for testing
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        // Add products
        Product1 p1 = new Product1("001", "Laptop", 10, 999.99);
        Product1 p2 = new Product1("002", "Smartphone", 20, 599.99);
        ims.addProduct(p1);
        ims.addProduct(p2);

        // Update a product
        Product1 p3 = new Product1("001", "Laptop", 15, 999.99);
        ims.updateProduct("001", p3);

        // Retrieve and print product details
        Product1 retrievedProduct = ims.getProduct("001");
        System.out.println("Product ID: " + retrievedProduct.getProductId());
        System.out.println("Product Name: " + retrievedProduct.getProductName());
        System.out.println("Quantity: " + retrievedProduct.getQuantity());
        System.out.println("Price: " + retrievedProduct.getPrice());

        // Delete a product
        ims.deleteProduct("002");
    }
}

// ###Analysis

// Time Complexity:

// Add Product: O(1)
// Update Product: O(1)
// Delete Product: O(1)

// ###Optimization:

// Load Factor Management: Ensure proper load factor to maintain constant-time
// complexity.
// Concurrency Handling: Use ConcurrentHashMap for simultaneous access and
// modifications.
// Garbage Collection: Clean up unused entries to optimize memory usage.

// Using a HashMap ensures efficient handling of large inventories with
// constant-time operations, making the system scalable and performant