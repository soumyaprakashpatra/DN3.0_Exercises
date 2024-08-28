package com.example.BookstoreAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDTO {
    private Long id;
    private String name;
    @JsonProperty("email_address")
    private String email;

    // Getters and Setters
}