package ru.otus.igorr.books.lesson12.repository.book;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.igorr.books.lesson12.domain.book.Note;
import ru.otus.igorr.books.lesson12.repository.abstracts.AbstractRepositoryTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static ru.otus.igorr.books.lesson12.utils.Constant.NOT_FOUND_DOCUMENT_ID;

@DisplayName("NoteRepositoryTest")
class NoteRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    NoteRepository noteRepository;

    @Test
    @DisplayName("getByIdTest")
    void getByIdTest(){
        Note note = noteRepository.findById("B1N1").orElse(Note.empty());
        assertNotEquals(NOT_FOUND_DOCUMENT_ID, note.getId());
    }

}