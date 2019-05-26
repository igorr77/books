package ru.otus.igorr.books.lesson18.repository.genre;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import ru.otus.igorr.books.lesson18.domain.genre.Genre;

public interface GenreReactiveRepository extends ReactiveMongoRepository<Genre, String> {

    Flux<Genre> findAll();
 }
