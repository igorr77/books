package ru.otus.igorr.books.lesson18.service.facade;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.dto.GenreDto;

public interface ReactiveFacade {
    Flux<GenreDto> getGenreList();

    Mono<GenreDto> getGenre(String id);

    Mono<GenreDto> addGenre(GenreDto genre);
}
