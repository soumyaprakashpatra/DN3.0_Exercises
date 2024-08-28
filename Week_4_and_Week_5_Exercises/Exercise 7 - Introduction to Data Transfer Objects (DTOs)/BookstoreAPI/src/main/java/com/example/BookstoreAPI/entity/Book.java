// src/main/java/com/yourcompany/bookstoreapi/entity/Book.java
package com.example.BookstoreAPI.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private LocalDate publicationDate;
    private Double price;

    // Getters and Setters
}

// src/main/java/com/yourcompany/bookstoreapi/entity/Customer.java

