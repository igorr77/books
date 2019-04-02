package ru.otus.igorr.books.lesson08.repository.genre;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import ru.otus.igorr.books.lesson08.domain.genre.Genre;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@EnableAutoConfiguration
@ContextConfiguration(classes = {GenreRepositoryImpl.class})
@EntityScan(basePackageClasses = Genre.class)
class GenreRepositoryImplTest {

    private Genre expectedGenre;

    @Autowired
    GenreRepository repository;

    @BeforeEach
    void setUp() {
        expectedGenre = new Genre();
        expectedGenre.setName("Test Genre");
        expectedGenre.setDescription("Test Description");
        repository.save(expectedGenre);
    }

    @Test
    void getByIdTest() {
        Genre genre = repository.getById(1);
        assertEquals(expectedGenre, genre);
    }

    @Test
    void getListTest() {
        List<Genre> list = repository.getList();
        assertAll(() -> assertEquals(1, list.size()),
                () -> assertEquals(expectedGenre, list.get(0)));
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