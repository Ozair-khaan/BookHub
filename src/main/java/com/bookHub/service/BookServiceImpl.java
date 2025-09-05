package com.bookHub.service;

import com.bookHub.entity.Book;
import com.bookHub.exception.BookNotFoundException;
import com.bookHub.repo.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return Optional.ofNullable(bookRepository.findById(id).orElseThrow(()->new BookNotFoundException("Book not found with id : "+id)));
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> updateBook(Long id, Book bookDetails) {
        return Optional.ofNullable(bookRepository.findById(id)
                .map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            return bookRepository.save(book);
        }).orElseThrow(()->new BookNotFoundException("Cannot update. Book not found with id: "+id)));
    }

    @Override
    public boolean deleteBook(Long id) {
         Book book = bookRepository.findById(id).orElseThrow(() ->new BookNotFoundException("Cannot delete. Book not found with id : "+id));
         bookRepository.delete(book);
         return true;
    }
}
