package com.example.bookstoreapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1)
    private String title;

    @NotNull
    private String author;

    @Min(0)
    private double price;

    private String isbn;

    @Version
    private Long version; // Optimistic Locking Version
}