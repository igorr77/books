package ru.otus.igorr.books.lesson18.service.facade;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.dto.AuthorDto;
import ru.otus.igorr.books.lesson18.dto.GenreDto;

public interface RServicesFacade {

    // Genre
    Flux<GenreDto> getGenreList();

    Mono<GenreDto> getGenre(String id);

    Mono<GenreDto> addGenre(GenreDto genre);

    Flux<GenreDto> getGenreListByName(String mask);

    void deleteGenre(String id);

    void deleteGenre(GenreDto dto);


    // AuthorService
    Mono<AuthorDto> getAuthor(String id);

    Flux<AuthorDto> getAuthorList();

    Flux<AuthorDto> getAuthorListByName(String mask);

    Mono<AuthorDto> addAuthor(AuthorDto dto);

    void deleteAuthor(String id);

    //
}
