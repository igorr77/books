package ru.otus.igorr.books.lesson18.service.facade;

import reactor.core.publisher.Flux;
import ru.otus.igorr.books.lesson18.dto.GenreDto;

public interface ReactiveFacade {
    Flux<GenreDto> findAll();
}
