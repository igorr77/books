package ru.otus.igorr.books.lesson06.services.genre;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson06.domain.Genre;
import ru.otus.igorr.books.lesson06.exceptions.GenreNotFoundException;

import java.util.List;

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
        assertNotNull(service.get(1));
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
        int createId = service.save(genre);
        genre.setId(createId);
        int count = service.delete(genre);
        assertEquals(1, count);

    }

    @Test
    void maxTest() {
        assertNotNull(service.getMaxId());
    }

    @Test
    void listTest() {
        List<Genre> genreList = service.getList("");
        assertNotEquals(0, genreList.size());
    }
}