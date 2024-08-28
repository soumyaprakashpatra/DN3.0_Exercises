package com.example.BookstoreAPI.service;

import com.example.BookstoreAPI.entity.Book;
import java.util.List;

public interface BookService {
    Book saveBook(Book book);
    Book findBookById(Long id);
    List<Book> findBooksByFilter(String title, String author);
    void deleteBook(Long id);
}
