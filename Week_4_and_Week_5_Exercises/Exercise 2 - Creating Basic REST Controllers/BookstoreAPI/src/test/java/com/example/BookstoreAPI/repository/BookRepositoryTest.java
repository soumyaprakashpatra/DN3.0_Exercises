package com.example.BookstoreAPI.repository;

import com.example.BookstoreAPI.entity.Book;
import com.example.BookstoreAPI.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.ANY)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testCreateBook() {
        Book book = new Book("Title", "Author", 29.99, "1234567890");
        bookRepository.save(book);

        Book foundBook = bookRepository.findById(book.getId()).orElse(null);
        assertThat(foundBook).isNotNull();
        assertThat(foundBook.getTitle()).isEqualTo("Title");
    }
}
