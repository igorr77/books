package ru.otus.igorr.books.lesson06.services.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson06.domain.Book;
import ru.otus.igorr.books.lesson06.exceptions.BookNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceImplTest {

    @Autowired
    private BookService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getTest() {
        Book book = service.get(4);
        assertNotNull(book);
    }

    @Test
    void getExceptionTest() {
        assertThrows(BookNotFoundException.class, () -> service.get(0));
    }

    @Test
    void saveInsertTest() {
        Book book = new Book();
        book.setAuthorId(1);
        book.setGenreId(1);
        book.setTitle("Title SaveInsertTest");
        book.setIsbn("0123456789");
        book.setPages(99);
        book.setDescription("Description save Insert Test");
        assertNotEquals(0, service.save(book));
    }

    @Test
    void saveUpdateTest() {
        Book book = new Book();
        book.setId(1);
        book.setAuthorId(1);
        book.setGenreId(1);
        book.setTitle("Title SaveUpdateTest");
        book.setIsbn("9876543210");
        book.setPages(99);
        book.setDescription("Description save Update Test");
        assertEquals(1, service.save(book));

    }

    @Test
    void delete() {
    }

    @Test
    void getList() {
    }

    @Test
    void max() {
    }
}