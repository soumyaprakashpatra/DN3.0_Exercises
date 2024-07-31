//#### 1. Understand Sorting Algorithms

// Bubble Sort: O(n²) - Repeatedly swaps adjacent elements until sorted. Inefficient for large datasets.
// Insertion Sort: O(n²) - Inserts elements into their correct position in a sorted part. Similar inefficiency to Bubble Sort.
// Quick Sort: O(n log n) - Divides and conquers using a pivot. Efficient for large datasets.
// Merge Sort: O(n log n) - Divides and merges sorted halves. Consistently efficient.

//#### 2. Setup

import java.util.Arrays;

class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }


    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

// Bubble Sort implementation
class BubbleSort {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }
}

// Quick Sort implementation
class QuickSort {
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}

// ### 3 implementation
public class SortingCustomerOrder {
    public static void main(String[] args) {
        Order[] orders = {
                new Order("001", "Alice", 250.0),
                new Order("002", "Bob", 150.0),
                new Order("003", "Charlie", 300.0),
                new Order("004", "Diana", 100.0),
                new Order("005", "Eve", 200.0)
        };

        // Bubble Sort
        Order[] bubbleSortedOrders = Arrays.copyOf(orders, orders.length);
        BubbleSort.bubbleSort(bubbleSortedOrders);
        System.out.println("Bubble Sorted Orders:");
        for (Order order : bubbleSortedOrders) {
            System.out.println(order);
        }

        // Quick Sort
        Order[] quickSortedOrders = Arrays.copyOf(orders, orders.length);
        QuickSort.quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        System.out.println("Quick Sorted Orders:");
        for (Order order : quickSortedOrders) {
            System.out.println(order);
        }
    }
}
// ## 4 Analysis:

// Time Complexity Comparison:

// Bubble Sort: O(n²) - Inefficient for large datasets due to repeated comparisons and swaps.
// Quick Sort: O(n log n) - More efficient due to its divide-and-conquer approach, even with large datasets.
// Why Quick Sort is Preferred:

// Efficiency: Quick Sort has a significantly better average-case time complexity (O(n log n)) compared to Bubble Sort (O(n²)).
// Scalability: Quick Sort performs well with large datasets and is often used in practice for its speed and efficiency.

// By using Quick Sort, you can efficiently sort customer orders by their total price, making it ideal for handling large volumes of data on an e-commerce platform.