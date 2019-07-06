package ru.otus.igorr.books.lesson20.repository.movie;

import reactor.core.publisher.Flux;
import ru.otus.igorr.books.lesson20.domain.movie.Movie;

public interface MovieRepository {
    Flux<Movie> findAll();
}
