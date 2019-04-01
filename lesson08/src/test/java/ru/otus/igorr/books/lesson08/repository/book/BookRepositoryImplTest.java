package ru.otus.igorr.books.lesson08.repository.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson08.domain.book.Book;
import ru.otus.igorr.books.lesson08.domain.book.Note;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BookRepositoryImplTest {


    @Autowired
    BookRepository repository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getById() {
    }

    @Test
    void saveTest() {

        List<Note> noteList = new ArrayList<>();

        Book book = new Book();
        book.setTitle("Title");
        book.setNote(noteList);
    }

    @Test
    void getList() {
    }

    @Test
    void delete() {
    }

    @Test
    void addNote() {
    }
}