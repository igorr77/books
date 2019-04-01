package ru.otus.igorr.books.lesson08.repository.genre;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson08.domain.genre.Genre;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class GenreRepositoryImplTest {


    private Genre actualGenre;

    @Autowired
    GenreRepository repository;

    @BeforeEach
    void setUp() {
        actualGenre = new Genre();
        actualGenre.setName("Test Genre");
        actualGenre.setDescription("Test Description");
        repository.save(actualGenre);
    }

    @Test
    void getByIdTest() {
        Genre genre = repository.getById(1);
        assertEquals(actualGenre, genre);
    }

    @Test
    void getListTest() {
        List<Genre> list = repository.getList();
        assertAll(() -> assertEquals(1, list.size()),
                () -> assertEquals(actualGenre, list.get(0)));
    }

    @Test
    void deleteTest() {
        Genre delGenre = new Genre();
        delGenre.setId(1);
        repository.delete(delGenre);
        Genre genre = repository.getById(1);
        assertNull(genre);
    }
}