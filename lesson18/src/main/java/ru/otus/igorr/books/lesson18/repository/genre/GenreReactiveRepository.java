package ru.otus.igorr.books.lesson18.repository.genre;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson18.domain.genre.Genre;

@Repository
public interface GenreReactiveRepository extends ReactiveMongoRepository<Genre, String> {
    //Flux<Genre> findAll();

    //Mono<Genre> findById(String id);
}
