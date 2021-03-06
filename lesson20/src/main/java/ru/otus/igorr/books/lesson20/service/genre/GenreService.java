package ru.otus.igorr.books.lesson20.service.genre;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson20.dto.GenreDto;

public interface GenreService {

    Flux<GenreDto> list();

    Flux<GenreDto> getListByName(String mask);

    Mono<GenreDto> get(String id);

    Mono<GenreDto> add(GenreDto genreDto);

    Mono<Void> delete(String id);

    Mono<Void> delete(GenreDto genreDto);


}
