package ru.otus.igorr.books.lesson18.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.dto.AuthorDto;
import ru.otus.igorr.books.lesson18.dto.GenreDto;
import ru.otus.igorr.books.lesson18.service.author.AuthorReactiveService;
import ru.otus.igorr.books.lesson18.service.book.BookReactiveService;
import ru.otus.igorr.books.lesson18.service.genre.GenreReactiveService;


@Service
public class RServicesFacadeImpl implements RServicesFacade {

    private final GenreReactiveService genreService;
    private final AuthorReactiveService authorService;
    private final BookReactiveService bookService;

    @Autowired
    public RServicesFacadeImpl(GenreReactiveService genreService,
                               AuthorReactiveService authorService,
                               BookReactiveService bookService) {
        this.genreService = genreService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    // Genre
    @Override
    public Flux<GenreDto> getGenreList() {
        return genreService.list();
    }

    @Override
    public Mono<GenreDto> getGenre(String id) {
        return genreService.get(id);
    }

    @Override
    public Mono<GenreDto> addGenre(GenreDto genre) {
        return genreService.add(genre);
    }

    @Override
    public Flux<GenreDto> getGenreListByName(String mask) {
        return null;
    }

    @Override
    public void deleteGenre(String id) {
        genreService.delete(id);
    }

    @Override
    public void deleteGenre(GenreDto genreDto) {
        genreService.delete(genreDto);
    }

    // Author
    @Override
    public Mono<AuthorDto> getAuthor(String id) {
        return null;
    }

    @Override
    public Flux<AuthorDto> getAuthorList() {
        return null;
    }

    @Override
    public Flux<AuthorDto> getAuthorListByName(String mask) {
        return null;
    }

    @Override
    public Mono<AuthorDto> addAuthor(AuthorDto dto) {
        return null;
    }

    @Override
    public void deleteAuthor(String id) {

    }


}
