package com.example.BookstoreAPI.service.impl;

import com.example.BookstoreAPI.entity.Book;
import com.example.BookstoreAPI.repository.BookRepository;
import com.example.BookstoreAPI.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findBooksByFilter(String title, String author) {
        if (title != null && author != null) {
            return bookRepository.findByTitleAndAuthor(title, author);
        } else if (title != null) {
            return bookRepository.findByTitle(title);
        } else if (author != null) {
            return bookRepository.findByAuthor(author);
        } else {
            return bookRepository.findAll();
        }
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
