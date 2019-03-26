package ru.otus.igorr.books.lesson06.services.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson06.domain.Book;
import ru.otus.igorr.books.lesson06.exceptions.BookNotFoundException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceImplTest {

    private static final String ISBN9 = "123456789";
    private static final String ISBN13 = "1234567890123";

    @Autowired
    private BookService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getTest() {
        Book book = service.get(1);
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
        book.setIsbn(ISBN13);
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
        book.setIsbn(ISBN13);
        book.setPages(99);
        book.setDescription("Description save Update Test");
        assertEquals(1, service.save(book));

    }

    @Test
    void delete() {
        Book book = new Book();
        book.setAuthorId(1);
        book.setGenreId(1);
        book.setTitle("Title Delete Test");
        book.setIsbn(ISBN9);
        book.setPages(99);
        book.setDescription("Description Delete Test");
        int createId = service.save(book);
        book.setId(createId);

        assertEquals(1, service.delete(book));
    }

    @Test
    void getListTest() {
        List<Book> bookList = service.getList("");
        assertNotEquals(0, bookList.size());
    }

    @Test
    void max() {
        assertNotNull(service.max());
    }
}