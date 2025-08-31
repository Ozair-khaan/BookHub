package com.bookHub.service;

import com.bookHub.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();
    Optional<Book> getBookById(Long id);
    Book createBook(Book book);
    Optional<Book> updateBook(Long id, Book bookDetails);
    boolean deleteBook(Long id);
}

