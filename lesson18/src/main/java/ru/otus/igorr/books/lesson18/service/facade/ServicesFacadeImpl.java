package ru.otus.igorr.books.lesson18.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.dto.AuthorDto;
import ru.otus.igorr.books.lesson18.dto.BookDto;
import ru.otus.igorr.books.lesson18.dto.GenreDto;
import ru.otus.igorr.books.lesson18.dto.NoteDto;
import ru.otus.igorr.books.lesson18.service.author.AuthorService;
import ru.otus.igorr.books.lesson18.service.book.BookService;
import ru.otus.igorr.books.lesson18.service.genre.GenreService;


@Service
public class ServicesFacadeImpl implements ServicesFacade {

    private final GenreService genreService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public ServicesFacadeImpl(GenreService genreService,
                              AuthorService authorService,
                              BookService bookService) {
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
    public Mono<Void> deleteGenre(String id) {
        return genreService.delete(id);
    }

    @Override
    public Mono<Void> deleteGenre(GenreDto genreDto) {
        return genreService.delete(genreDto);
    }

    // Author
    @Override
    public Mono<AuthorDto> getAuthor(String id) {
        return authorService.get(id);
    }

    @Override
    public Flux<AuthorDto> getAuthorList() {
        return authorService.getList();
    }

    @Override
    public Flux<AuthorDto> getAuthorListByName(String mask) {
        return authorService.getListByName(mask);
    }

    @Override
    public Mono<AuthorDto> addAuthor(AuthorDto dto) {
        return authorService.add(dto);
    }

    @Override
    public Mono<Void> deleteAuthor(String id) {
        return authorService.delete(id);
    }

    // Book
    @Override
    public Flux<BookDto> getBookList() {
        return bookService.getList();
    }

    @Override
    public Mono<BookDto> getBook(String id) {
        return bookService.get(id);
    }

    @Override
    public Mono<BookDto> addBook(BookDto bookDto) {
        return bookService.add(bookDto);
    }

    @Override
    public Mono<Void> deleteBook(String id) {
        return bookService.delete(id);
    }

    @Override
    public Mono<NoteDto> addNote(NoteDto noteDto) {
        return bookService.addNote(noteDto);
    }

    @Override
    public Mono<Void> deleteNote(String noteId) {
        return bookService.deleteNote(noteId);
    }
}
