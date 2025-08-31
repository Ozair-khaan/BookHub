package com.bookHub.repo;

import com.bookHub.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
   /* private Map<Long, Book> bookStore = new HashMap<>();
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
    }*/
}
