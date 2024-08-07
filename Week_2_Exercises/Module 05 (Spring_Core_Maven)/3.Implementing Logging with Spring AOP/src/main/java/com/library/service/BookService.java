package com.library.service;

import com.library.model.*;
import com.library.repository.BookRepository;

import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public boolean removeBookById(int id) {
        return bookRepository.deleteById(id);
    }

    public void performService() {
        List<Book> allBooks = getAllBooks();
        System.out.println("All Books: " + allBooks);

        Book book = getBookById(1);
        System.out.println("Book with ID 1: " + book);

        addBook(new Book(4, "Brave New World", "Aldous Huxley"));
        System.out.println("Added new book. All Books: " + getAllBooks());

        addBook(new Book(5, "Harry Potter", "J.K. Rowling"));
        System.out.println("Added Harry Potter. All Books: " + getAllBooks());

        removeBookById(2);
        System.out.println("Deleted book with ID 2. All Books: " + getAllBooks());
    }
}
