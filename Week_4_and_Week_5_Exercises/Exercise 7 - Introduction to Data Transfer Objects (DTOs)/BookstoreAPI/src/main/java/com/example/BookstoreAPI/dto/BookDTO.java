// src/main/java/com/yourcompany/bookstoreapi/dto/BookDTO.java
package com.example.BookstoreAPI.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class BookDTO {
    private Long id;
    private String title;
    private String author;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")    private LocalDate publicationDate;
    private Double price;

    // Getters and Setters
}
