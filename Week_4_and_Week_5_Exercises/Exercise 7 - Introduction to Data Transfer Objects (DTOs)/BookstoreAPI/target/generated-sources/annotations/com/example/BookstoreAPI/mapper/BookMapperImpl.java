package com.example.BookstoreAPI.mapper;

import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.entity.Book;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-22T16:46:56+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDTO bookToBookDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        return bookDTO;
    }

    @Override
    public Book bookDTOToBook(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        return book;
    }
}
