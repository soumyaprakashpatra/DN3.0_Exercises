package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.entity.Book;
import com.example.BookstoreAPI.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.findById(id); // This will throw ResourceNotFoundException if not found
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book-Fetched");
        return new ResponseEntity<>(book, headers, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book-Added");
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Optional<Book> existingBookOpt = bookService.getBookById(id);
        if (existingBookOpt.isPresent()) {
            bookService.updateBook(id, updatedBook);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "Book-Updated");
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Optional<Book> existingBookOpt = bookService.getBookById(id);
        if (existingBookOpt.isPresent()) {
            bookService.deleteBook(id);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "Book-Deleted");
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
