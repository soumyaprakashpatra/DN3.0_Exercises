
// Step 1: Understanding Search Algorithms
// Linear Search:
// - Time Complexity: O(n) - Each element is checked sequentially until the target is found or the end is reached.
// - Suitable for: Unsorted or small datasets.

// Binary Search:
// - Time Complexity: O(log n) - The search space is divided in half each time, reducing the search space logarithmically.
// - Suitable for: Large, sorted datasets.

import java.util.Arrays;


class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }


    public String getBookId() { 
        return bookId;
     }
    public String getTitle() {
         return title;
         }
    public String getAuthor() {
         return author; 
        }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

public class LibraryManagementSystem {
    private Book[] books;
    private int size;

    public LibraryManagementSystem(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    // Add book
    public void addBook(Book book) {
        if (size < books.length) {
            books[size++] = book;
        } else {
            System.out.println("Array is full. Cannot add more books.");
        }
    }

    // Linear search by title
    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    // Binary search by title (requires sorted array)
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = size - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);

            if (cmp == 0) {
                return books[mid];
            }
            if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Sort books by title (for binary search)
    public void sortBooksByTitle() {
        Arrays.sort(books, 0, size, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem(5);

        library.addBook(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("B002", "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("B003", "1984", "George Orwell"));

        // Sort books by title for binary search
        library.sortBooksByTitle();

        System.out.println("Searching for '1984' using linear search:");
        Book book = library.linearSearchByTitle("1984");
        System.out.println(book);

        System.out.println("\nSearching for '1984' using binary search:");
        book = library.binarySearchByTitle("1984");
        System.out.println(book);
    }
}

    // Step 4: Analysis
    // Time Complexity:
    // - Linear Search: O(n) - Searches through each element sequentially.
    // - Binary Search: O(log n) - Efficient for sorted arrays.

    // Use Cases:
    // - Linear Search: Ideal for unsorted or small datasets.
    // - Binary Search: Ideal for large, sorted datasets to leverage faster search time