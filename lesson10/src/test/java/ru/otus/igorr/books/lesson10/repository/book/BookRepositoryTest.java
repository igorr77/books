package ru.otus.igorr.books.lesson10.repository.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ru.otus.igorr.books.lesson10.domain.book.Book;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class BookRepositoryTest {

    private static final Book EMPTY_BOOK = new Book();
    private static final long FIND_ID = 1L;
    private static final long DELETE_ID = 999L;

    @Autowired
    BookRepository bookRepository;


    @BeforeEach
    void setUp() {
        EMPTY_BOOK.setId(-1L);
    }

    @Test
    void findByIdTest() {
        Book actualBook = bookRepository.findById(FIND_ID).orElse(EMPTY_BOOK);
        assertEquals(FIND_ID, actualBook.getId());
    }

    @Test
    void deleteTest() {

        Book actualBook = bookRepository.findById(DELETE_ID).orElse(EMPTY_BOOK);

        Book delBook = new Book();
        delBook.setId(DELETE_ID);
        bookRepository.delete(delBook);

        Book deletedBook = bookRepository.findById(DELETE_ID).orElse(EMPTY_BOOK);

        assertAll(
                () -> assertEquals(DELETE_ID, actualBook.getId()),
                () -> assertEquals(EMPTY_BOOK.getId(), deletedBook.getId())
        );

    }

    @Test
    void findAllTest() {
        Page<Book> page = bookRepository.findAll(PageRequest.of(1, 2, new Sort(Sort.Direction.ASC, "id")));
        assertEquals(4L, page.getContent().get(1).getId());
    }

}