package ru.otus.igorr.books.lesson18.repository.genre;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.otus.igorr.books.lesson18.domain.genre.Genre;
import ru.otus.igorr.books.lesson18.repository.abstracts.AbstractRepositoryTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenreReactiveRepositoryTest extends AbstractRepositoryTest {


    @Autowired
    private GenreReactiveRepository repository;

    @Autowired
    private GenreRepository r;


    @Before
    public void setUp() throws Exception {
    }


    // l15
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    public void findByIdTest(String param) {
        Genre genre = r.findById(param).orElse(Genre.empty());
        assertEquals(param, genre.getId());
    }


    // flux
    @Test
    public void saveTest() {

//    @ParameterizedTest
//    @ValueSource(strings = {"1", "2", "3"})
//    public void saveTest(String param) {


        Genre g = r.findById("1").orElse(Genre.empty());

        Mono<Genre> genreMono = repository.save(new Genre(null, "Name", "Description"));

        StepVerifier
                .create(genreMono)
                .assertNext(genre -> assertNotNull(genre.getId()))
                .expectComplete()
                .verify();

    }

    @Test
    public void findAllTest() {


    }

    @Test
    public void findByIdTest() {
    }
}