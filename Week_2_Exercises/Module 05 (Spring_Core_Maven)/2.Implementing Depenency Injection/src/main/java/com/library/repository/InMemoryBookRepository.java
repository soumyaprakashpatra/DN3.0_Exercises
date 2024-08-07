package com.library.repository;

import java.util.ArrayList;
import java.util.List;

import com.library.model.Book;

public class InMemoryBookRepository implements BookRepository {

    private List<Book> books = new ArrayList<>();

    public InMemoryBookRepository() {
        
        books.add(new Book(1, "1984", "George Orwell"));
        books.add(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(3, "The Great Gatsby", "F. Scott Fitzgerald"));
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book findById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void save(Book book) {
        books.add(book);
    }

    @Override
    public boolean deleteById(int id) {
        return books.removeIf(book -> book.getId() == id);
    }
}
