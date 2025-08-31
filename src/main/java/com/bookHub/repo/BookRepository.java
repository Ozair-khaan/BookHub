package com.bookHub.repo;

import com.bookHub.model.Book;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepository {
    private Map<Long, Book> bookStore = new HashMap<>();
    private Long counter = 1L;

    public List<Book> findAll() {
        return new ArrayList<>(bookStore.values());
    }

    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(bookStore.get(id));
    }

    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(counter++);
        }
        bookStore.put(book.getId(), book);
        return book;
    }

    public void deleteById(Long id) {
        bookStore.remove(id);
    }
}
