package ru.otus.igorr.books.lesson18.service.genre;

import reactor.core.publisher.Flux;
import ru.otus.igorr.books.lesson18.dto.GenreDto;

public interface GenreReactiveService {
    Flux<GenreDto> findAll();
}
