package com.example.bookstoreapi.service;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final MeterRegistry meterRegistry;

    public BookService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    public void addBook() {
        // Add book logic here
        meterRegistry.counter("custom.book.count", "type", "books").increment();
    }
}