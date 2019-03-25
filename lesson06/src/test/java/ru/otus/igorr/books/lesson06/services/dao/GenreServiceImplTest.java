package ru.otus.igorr.books.lesson06.services.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson06.domain.Genre;
import ru.otus.igorr.books.lesson06.exceptions.GenreNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GenreServiceImplTest {

    @Autowired
    GenreService service;


    @BeforeEach
    void setUp() {

    }

    @Test
    void getTest() {
        assertNotNull(service.get(5));
    }

    @Test
    void getExceptionTest() {
        assertThrows(GenreNotFoundException.class, () -> service.get(0), "Text");
    }

    @ParameterizedTest
    @ValueSource(ints = 4)
    void saveUpdateTest(int param) {
        Genre genre = new Genre("Genre Update", "Description Update");
        genre.setId(param);
        int id = service.save(genre);
        assertEquals(param, id);
    }

    @Test
    void saveInsertTest() {
        Genre genre = new Genre("Genre Insert", "Description Insert");
        int id = service.save(genre);
        assertNotEquals(0, id);
    }


    @Test
    void deleteTest() {
        Genre genre = new Genre("Genre Delete", "Description Delete");
        genre.setId(3);
        int count = service.delete(genre);
        assertNotEquals(0, count);

    }

    @Test
    void maxTest() {
        int i = service.max();
    }
}