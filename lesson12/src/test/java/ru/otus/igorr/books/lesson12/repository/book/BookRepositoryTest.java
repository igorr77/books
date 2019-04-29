package ru.otus.igorr.books.lesson12.repository.book;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.igorr.books.lesson12.domain.book.Book;
import ru.otus.igorr.books.lesson12.repository.abstracts.AbstractRepositoryTest;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BookRepositoryTest")
class BookRepositoryTest extends AbstractRepositoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(BookRepositoryTest.class);

    @Autowired
    BookRepository bookRepository;

    @Autowired
    NoteRepository noteRepository;


    @Test
    @DisplayName("getByIdTest")
    void getByIdTest() {
        Book book = bookRepository.findById("BID001").orElse(Book.empty());
        assertAll(
                () -> assertEquals("BID001", book.getId()),
                () -> assertEquals(2, book.getAuthors().size()),
                () -> assertEquals("Get.Genre.Name.1", book.getGenre().getName())
        );

    }

    @Test
    void existsAuthorTest() {
        assertAll(
                () -> assertTrue(bookRepository.existsAuthor("A1")),
                () -> assertTrue(bookRepository.existsAuthor("A2")),
                () -> assertFalse(bookRepository.existsAuthor("A3"))
        );
    }

}