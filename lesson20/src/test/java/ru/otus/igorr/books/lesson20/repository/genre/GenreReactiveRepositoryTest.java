package ru.otus.igorr.books.lesson20.repository.genre;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.otus.igorr.books.lesson20.domain.genre.Genre;
import ru.otus.igorr.books.lesson20.repository.abstracts.AbstractRepositoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GenreReactiveRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private GenreReactiveRepository repository;

    @Test
    public void saveTest() {
        Mono<Genre> genreMono = repository.save(new Genre(null, "Genre.Name.Flux", "Description.Flux"));
        StepVerifier
                .create(genreMono)
                .assertNext(genre -> assertNotNull(genre.getId()))
                .expectComplete()
                .verify();
    }

    @Test
    public void findAllTest() {
        Flux<Genre> genreFlux = repository.findAll();

        Long error = genreFlux
                .map(genre -> genre.getId() != null)
                .filter(p -> !p)
                .count()
                .block();

        Long done = genreFlux
                .map(genre -> genre.getId() != null)
                .filter(p -> p)
                .count()
                .block();


        assertEquals(Long.valueOf(0),error);
        assertNotEquals(Long.valueOf(0),done);
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