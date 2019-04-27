package ru.otus.igorr.books.lesson10.repository.genre;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.otus.igorr.books.lesson10.domain.genre.Genre;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@EnableAutoConfiguration
//@ContextConfiguration(classes = {GenreRepository.class})
//@EntityScan(basePackageClasses = Genre.class)
class GenreRepositoryTest {

    private static final long DELETED_ID = 999L;
    private Genre expectedGenre;
    private Genre empyGenre;

    @Autowired
    GenreRepository repository;

    @BeforeEach
    void setUp() {
        empyGenre = new Genre();
        empyGenre.setId(-1L);

    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void findByIdTest(int param) {
        Genre genre = repository.findById(Long.valueOf(param)).orElse(empyGenre);
        assertEquals(param, genre.getId());
    }

    @Test
    void deleteTest() {
        Genre delGenre = new Genre();
        delGenre.setId(DELETED_ID);
        repository.delete(delGenre);
        assertEquals(-1L, repository.findById(DELETED_ID).orElse(empyGenre).getId());
        int breakPoint = 0;
    }


    @Test
    void findAllTest() {
        List<Genre> list = repository.findAll();
        assertAll(
                () -> assertNotEquals(0, list.size()),
                () -> assertNotNull(list.get(2))
        );
    }


    @Test
    void findAllById() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);

        List<Genre> list = repository.findAllById(ids);
        assertAll(
                () -> assertEquals(2, list.size()),
                () -> assertEquals(2, list.get(1).getId())
        );
    }


}