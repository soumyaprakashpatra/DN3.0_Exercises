package com.library.repository;

import java.util.List;

import com.library.model.Book;

public interface BookRepository {
    List<Book> findAll();
    Book findById(int id);
    void save(Book book);
    boolean deleteById(int id);
}
