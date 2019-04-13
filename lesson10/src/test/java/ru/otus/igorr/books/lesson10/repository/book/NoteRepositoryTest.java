package ru.otus.igorr.books.lesson10.repository.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ru.otus.igorr.books.lesson10.domain.book.Book;
import ru.otus.igorr.books.lesson10.domain.book.Note;

import java.util.Set;


@DataJpaTest
class NoteRepositoryTest {

    @Autowired
    NoteRepository noteRepository;


    @Test
    void findByIdTest() {
        Note note = noteRepository.findById(1L).orElse(new Note());
        int breakPoint = 0;
    }

    @Test
    void findByBookTest() {
        Book book = new Book();
        book.setId(1L);

        Set<Note> notes = noteRepository.findByBook(book);
        int breakPoint = 0;
    }

    @Test
    void findAllPageTest() {
        Page<Note> page = noteRepository.findAll(PageRequest.of(0, 20, new Sort(Sort.Direction.ASC, "noteId")));
        //Page<Note> page = noteRepository.findAll(PageRequest.of(0, 20));
        int breakPoint = 0;
    }

}