package com.example.BookstoreAPI;

import com.example.BookstoreAPI.controller.BookController;
import com.example.BookstoreAPI.entity.Book;
import com.example.BookstoreAPI.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookstoreApiApplicationTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void testGetBookById_Found() throws Exception {
        Book book = new Book("It Ends With Us", "Collen Hoover", "It Ends with Us is a book that follows a girl named Lily who has just moved and is ready to start her life after college. Lily then meets a guy named Ryle and she falls for him. As she is developing feelings for Ryle, Atlas, her first love, reappears and challenges the relationship between Lily and Ryle.");
        book.setId(1L);

        when(bookService.findBookById(1L)).thenReturn(book);

        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("It Ends With Us"))
                .andExpect(jsonPath("$.author").value("Collen Hoover"))
                .andExpect(jsonPath("$.description").value("It Ends with Us is a book that follows a girl named Lily who has just moved and is ready to start her life after college. Lily then meets a guy named Ryle and she falls for him. As she is developing feelings for Ryle, Atlas, her first love, reappears and challenges the relationship between Lily and Ryle."));
    }

    @Test
    public void testGetBookById_NotFound() throws Exception {
        when(bookService.findBookById(1L)).thenReturn(null);

        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetBooksByFilter_TitleAndAuthor() throws Exception {
        List<Book> books = Arrays.asList(
                new Book("It Ends With Us", "Collen Hoover", "It Ends with Us is a book that follows a girl named Lily who has just moved and is ready to start her life after college. Lily then meets a guy named Ryle and she falls for him. As she is developing feelings for Ryle, Atlas, her first love, reappears and challenges the relationship between Lily and Ryle."),
                new Book("Twisted Love ", "Ana Huang", "Twisted Love is a romance novel by Ana Huang about a college student named Ava Chen and a cold-hearted millionaire named Alex who is forced to look after her. The book is the first in the Twisted series, but can be read as a standalone. \n")
        );

        when(bookService.findBooksByFilter("It Ends With Us", "Collen Hoover")).thenReturn(books);

        mockMvc.perform(get("/api/books")
                        .param("title", "It Ends With Us")
                        .param("author", "Collen Hoover"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title").value("It Ends With Us"))
                .andExpect(jsonPath("$[0].author").value("Collen Hoover"));
    }

    @Test
    public void testGetBooksByFilter_NoFilter() throws Exception {
        List<Book> books = Arrays.asList(
                new Book("It Ends With Us", "Collen Hoover", "It Ends with Us is a book that follows a girl named Lily who has just moved and is ready to start her life after college. Lily then meets a guy named Ryle and she falls for him. As she is developing feelings for Ryle, Atlas, her first love, reappears and challenges the relationship between Lily and Ryle."),
                new Book("Twisted Love", "Ana Huang", "Twisted Love is a romance novel by Ana Huang about a college student named Ava Chen and a cold-hearted millionaire named Alex who is forced to look after her. The book is the first in the Twisted series, but can be read as a standalone.")
        );

        when(bookService.findBooksByFilter(null, null)).thenReturn(books);

        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title").value("It Ends With Us"))
                .andExpect(jsonPath("$[1].title").value("Twisted Love"));
    }
}
