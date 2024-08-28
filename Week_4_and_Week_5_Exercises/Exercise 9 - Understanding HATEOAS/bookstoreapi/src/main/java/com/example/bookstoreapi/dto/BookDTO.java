package com.example.bookstoreapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO {

    private Long id;

    @NotNull(message = "Title cannot be null")
    @Size(min = 1, message = "Title must not be empty")
    private String title;

    @NotNull(message = "Author cannot be null")
    private String author;

    @Min(value = 0, message = "Price must be a positive number")
    private double price;

    private String isbn;
}