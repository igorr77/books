package ru.otus.igorr.books.lesson06.services.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson06.domain.Book;
import ru.otus.igorr.books.lesson06.exceptions.BookNotFoundException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void save() {
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