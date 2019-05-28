package ru.otus.igorr.books.lesson18.repository.genre;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.otus.igorr.books.lesson18.domain.genre.Genre;
import ru.otus.igorr.books.lesson18.repository.abstracts.AbstractRepositoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;

public class GenreReactiveRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private GenreReactiveRepository repository;


    @Test
    public void saveTest() {
        Mono<Genre> genreMono = repository.save(new Genre(null, "Name", "Description"));

        StepVerifier
                .create(genreMono)
                .assertNext(genre -> assertNotNull(genre.getId()))
                .expectComplete()
                .verify();

    }

    @Test
    public void findAllTest() {
        Flux<Genre> genreFlux = repository.findAll();

        assertEquals(Long.valueOf(6), genreFlux.count().block());

    }

    @Test
    public void findByIdTest() {
        Mono<Genre> genreMono = repository.findById("1");

        StepVerifier
                .create(genreMono)
                .assertNext(genre -> assertNotNull(genre.getId()))
                .expectComplete()
                .verify();

    }
}