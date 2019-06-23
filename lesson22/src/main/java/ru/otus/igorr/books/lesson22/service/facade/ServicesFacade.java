package ru.otus.igorr.books.lesson22.service.facade;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson22.dto.AuthorDto;
import ru.otus.igorr.books.lesson22.dto.BookDto;
import ru.otus.igorr.books.lesson22.dto.GenreDto;
import ru.otus.igorr.books.lesson22.dto.NoteDto;

public interface ServicesFacade {

    // Genre
    Flux<GenreDto> getGenreList();

    Mono<GenreDto> getGenre(String id);

    Mono<GenreDto> addGenre(GenreDto genre);

    Flux<GenreDto> getGenreListByName(String mask);

    Mono<Void> deleteGenre(String id);

    Mono<Void> deleteGenre(GenreDto genreDto);


    // Author services
    Mono<AuthorDto> getAuthor(String id);

    Flux<AuthorDto> getAuthorList();

    Flux<AuthorDto> getAuthorListByName(String mask);

    Mono<AuthorDto> addAuthor(AuthorDto authorDto);

    Mono<Void> deleteAuthor(String id);


    // Book services
    Flux<BookDto> getBookList();

    Mono<BookDto> getBook(String id);

    Mono<BookDto> addBook(BookDto bookDto);

    Mono<Void> deleteBook(String id);

    Mono<NoteDto> addNote(NoteDto noteDto);

    Mono<Void> deleteNote(String noteId);


}
