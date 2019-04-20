package ru.otus.igorr.books.lesson12.repository.book;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.igorr.books.lesson12.repository.abstracts.AbstractRepositoryTest;

@DisplayName("NoteRepositoryTest")
class NoteRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    NoteRepository noteRepository;

    @Test
    @DisplayName("getByIdTest")
    void getByIdTest(){

    }

}