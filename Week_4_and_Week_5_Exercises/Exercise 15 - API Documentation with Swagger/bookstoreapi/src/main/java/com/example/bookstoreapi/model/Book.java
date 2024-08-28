package com.example.bookstoreapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Details about the book")
public class Book {

    @Schema(description = "Unique ID of the book", example = "1")
    private Long id;

    @Schema(description = "Title of the book", example = "Spring Boot in Action")
    private String title;

    @Schema(description = "Author of the book", example = "Craig Walls")
    private String author;

    @Schema(description = "Price of the book", example = "29.99")
    private Double price;

    @Schema(description = "ISBN of the book", example = "9781617292545")
    private String isbn;

    // Getters and setters
}