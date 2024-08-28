// src/main/java/com/yourcompany/bookstoreapi/controller/BookController.java
package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.entity.Book;
import com.example.BookstoreAPI.mapper.BookMapper;
import com.example.BookstoreAPI.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks().stream()
                .map(BookMapper.INSTANCE::bookToBookDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public BookDTO addBook(@RequestBody BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.bookDTOToBook(bookDTO);
        Book savedBook = bookService.saveBook(book);
        return BookMapper.INSTANCE.bookToBookDTO(savedBook);
    }
}

