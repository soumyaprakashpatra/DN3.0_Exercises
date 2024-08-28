package com.example.BookstoreAPI.service;

import com.example.BookstoreAPI.entity.Book;
import com.example.BookstoreAPI.exception.ResourceNotFoundException;
import com.example.BookstoreAPI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with ID " + id + " not found"));
    }

    public Book updateBook(Long id, Book updatedBook) {
        Book existingBook = findById(id);
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setPrice(updatedBook.getPrice());
        return bookRepository.save(existingBook);
    }

    public void deleteBook(Long id) {
        Book book = findById(id);
        bookRepository.delete(book);
    }
}
