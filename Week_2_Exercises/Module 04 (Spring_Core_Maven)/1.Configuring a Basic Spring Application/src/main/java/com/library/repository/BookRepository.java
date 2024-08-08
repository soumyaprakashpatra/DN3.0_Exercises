package com.library.repository;

import java.util.ArrayList;
import java.util.List;

import com.library.model.*;

public class BookRepository {
    private List<Book> books = new ArrayList<>();

    public BookRepository() {
        // Initialize with some dummy data
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book(2, "1984", "George Orwell"));
        books.add(new Book(3, "To Kill a Mockingbird", "Harper Lee"));
    }

    // Method to get all books
    public List<Book> findAll() {
        return books;
    }

    // Method to find a book by ID
    public Book findById(int id) {
        return books.stream()
                    .filter(book -> book.getId() == id)
                    .findFirst()
                    .orElse(null);
    }

    // Method to add a new book
    public void save(Book book) {
        books.add(book);
    }

    // Method to delete a book by ID
    public boolean deleteById(int id) {
        return books.removeIf(book -> book.getId() == id);
    }
}
