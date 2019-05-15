package ru.otus.igorr.books.lesson15.service.facade;

import ru.otus.igorr.books.lesson15.dto.AuthorDto;
import ru.otus.igorr.books.lesson15.dto.BookDto;
import ru.otus.igorr.books.lesson15.dto.GenreDto;
import ru.otus.igorr.books.lesson15.dto.NoteDto;

import java.util.List;

public interface ServicesFacade {

    // BookService
    BookDto getBook(String id);

    List<BookDto> getBookList();

    String addBook(BookDto dto);

    void deleteBook(String id);

    /* Note */
    NoteDto getBookNote(String noteId);

    List<NoteDto> getBookNoteList(String bookId);

    NoteDto addBookNote(NoteDto dto);

    void deleteBookNote(String noteId);

    // GenreService
    GenreDto getGenre(String id);

    List<GenreDto> getGenreList();

    List<GenreDto> getGenreListByName(String mask);

    String addGenre(GenreDto genre);

    void deleteGenre(String id);

    void deleteGenre(GenreDto dto);


    // AuthorService

    AuthorDto getAuthor(String id);

    List<AuthorDto> getAuthorList();

    List<AuthorDto> getAuthorListByName(String mask);

    String addAuthor(AuthorDto dto);

    void deleteAuthor(String id);

}
