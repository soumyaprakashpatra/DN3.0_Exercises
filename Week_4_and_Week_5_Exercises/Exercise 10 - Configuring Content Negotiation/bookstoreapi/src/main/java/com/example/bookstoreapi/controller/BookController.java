package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.mapper.BookMapper;
import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.service.BookService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
@Validated
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper = BookMapper.INSTANCE;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(produces = { "application/json", "application/xml" })
    public ResponseEntity<CollectionModel<EntityModel<BookDTO>>> getAllBooks() {
        List<EntityModel<BookDTO>> bookDTOs = bookService.findAll().stream()
                .map(book -> bookMapper.toDTO(book))
                .map(bookDTO -> EntityModel.of(bookDTO,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(bookDTO.getId())).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withRel("books")))
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(bookDTOs,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withSelfRel()));
    }

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public ResponseEntity<EntityModel<BookDTO>> getBookById(@PathVariable("id") Long id) {
        return bookService.findById(id)
                .map(book -> {
                    BookDTO bookDTO = bookMapper.toDTO(book);
                    return ResponseEntity.ok(EntityModel.of(bookDTO,
                            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(id)).withSelfRel(),
                            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withRel("books")));
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping(consumes = { "application/json", "application/xml" }, produces = { "application/json", "application/xml" })
    public ResponseEntity<EntityModel<BookDTO>> createBook(@RequestBody @Valid BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        Book savedBook = bookService.save(book);
        BookDTO savedBookDTO = bookMapper.toDTO(savedBook);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(EntityModel.of(savedBookDTO,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(savedBookDTO.getId())).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withRel("books")));
    }

    @PutMapping(value = "/{id}", consumes = { "application/json", "application/xml" }, produces = { "application/json", "application/xml" })
    public ResponseEntity<EntityModel<BookDTO>> updateBook(@PathVariable("id") Long id,
                                                            @RequestBody @Valid BookDTO bookDTO) {
        return bookService.findById(id)
                .map(existingBook -> {
                    Book book = bookMapper.toEntity(bookDTO);
                    book.setId(id);
                    Book updatedBook = bookService.update(book);
                    BookDTO updatedBookDTO = bookMapper.toDTO(updatedBook);
                    return ResponseEntity.ok(EntityModel.of(updatedBookDTO,
                            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(id)).withSelfRel(),
                            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withRel("books")));
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
        return bookService.findById(id)
                .map(book -> {
                    bookService.delete(id);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}