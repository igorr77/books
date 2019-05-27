package ru.otus.igorr.books.lesson18.service.genre;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.dto.GenreDto;

public interface GenreReactiveService {

    Flux<GenreDto> list();

    Mono<GenreDto> get(String id);

    Mono<GenreDto> add(GenreDto genreDto);
}
