package ru.otus.igorr.books.lesson18.service.author;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.dto.AuthorDto;

public interface AuthorReactiveService {
    Mono<AuthorDto> get(String id);

    Mono<AuthorDto> add(AuthorDto dto);

    Flux<AuthorDto> getList();

    Flux<AuthorDto> getListByName(String mask);

    void delete(String id);
}
