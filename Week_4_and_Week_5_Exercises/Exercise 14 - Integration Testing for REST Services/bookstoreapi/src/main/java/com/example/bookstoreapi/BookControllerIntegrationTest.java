package com.example.bookstoreapi;

import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        bookRepository.deleteAll();
    }

    @Test
    public void testCreateBook() throws Exception {
        Book book = new Book(null, "Spring Boot in Action", "Craig Walls", 29.99, "9781617292545");
        String jsonContent = objectMapper.writeValueAsString(book);

        mockMvc.perform(post("/books")
                .contentType("application/json")
                .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Spring Boot in Action"));
    }

    @Test
    public void testGetBookById() throws Exception {
        Book book = bookRepository.save(new Book(null, "Spring Boot in Action", "Craig Walls", 29.99, "9781617292545"));

        mockMvc.perform(get("/books/" + book.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Spring Boot in Action"));
    }

    @Test
    public void testUpdateBook() throws Exception {
        Book book = bookRepository.save(new Book(null, "Spring Boot in Action", "Craig Walls", 29.99, "9781617292545"));
        Book updatedBook = new Book(book.getId(), "Spring Boot in Action (Updated)", "Craig Walls", 35.00, "9781617292545");
        String jsonContent = objectMapper.writeValueAsString(updatedBook);

        mockMvc.perform(put("/books/" + book.getId())
                .contentType("application/json")
                .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Spring Boot in Action (Updated)"));
    }

    @Test
    public void testDeleteBook() throws Exception {
        Book book = bookRepository.save(new Book(null, "Spring Boot in Action", "Craig Walls", 29.99, "9781617292545"));

        mockMvc.perform(delete("/books/" + book.getId()))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        mockMvc.perform(get("/books/" + book.getId()))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
