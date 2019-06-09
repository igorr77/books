package ru.otus.igorr.books.lesson20.service.author;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson20.dto.AuthorDto;

public interface AuthorService {
    Mono<AuthorDto> get(String id);

    Mono<AuthorDto> add(AuthorDto dto);

    Flux<AuthorDto> getList();

    Flux<AuthorDto> getListByName(String mask);

    Mono<Void> delete(String id);
}
