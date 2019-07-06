package ru.otus.igorr.books.lesson25.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson25.dto.AuthorDto;
import ru.otus.igorr.books.lesson25.dto.BookDto;
import ru.otus.igorr.books.lesson25.dto.GenreDto;
import ru.otus.igorr.books.lesson25.dto.NoteDto;
import ru.otus.igorr.books.lesson25.service.author.AuthorService;
import ru.otus.igorr.books.lesson25.service.book.BookService;
import ru.otus.igorr.books.lesson25.service.genre.GenreService;

import java.util.List;

@Service
public class ServicesFacadeImpl implements ServicesFacade {

    private final GenreService genreService;
    private final AuthorService authorService;
    private final BookService bookService;


    @Autowired
    public ServicesFacadeImpl(GenreService genreService, AuthorService authorService, BookService bookService) {
        this.genreService = genreService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public BookDto getBook(String id) {
        return bookService.get(id);
    }

    @Override
    public List<BookDto> getBookList() {
        return bookService.getList();
    }

    @Override
    public String addBook(BookDto dto) {
        return bookService.add(dto);
    }

    @Override
    public void deleteBook(String id) {
        bookService.delete(id);
    }

    @Override
    public NoteDto getBookNote(String noteId) {
        return bookService.getNote(noteId);
    }

    @Override
    public List<NoteDto> getBookNoteList(String bookId) {
        return bookService.getNoteList(bookId);
    }

    @Override
    public NoteDto addBookNote(NoteDto dto) {
        return bookService.addNote(dto);
    }

    @Override
    public void deleteBookNote(String noteId) {
        bookService.deleteNote(noteId);
    }

    // Genre
    @Override
    public GenreDto getGenre(String id) {
        return genreService.get(id);
    }

    @Override
    public List<GenreDto> getGenreList() {
        return genreService.getList();
    }

    @Override
    public List<GenreDto> getGenreListByName(String mask) {
        return genreService.getListByName(mask);
    }

    @Override
    public String addGenre(GenreDto genre) {
        return genreService.add(genre);
    }

    @Override
    public void deleteGenre(String id) {
        genreService.delete(id);
    }

    @Override
    public void deleteGenre(GenreDto dto) {
        genreService.delete(dto);
    }

    // Author

    @Override
    public AuthorDto getAuthor(String id) {
        return authorService.get(id);
    }

    @Override
    public List<AuthorDto> getAuthorList() {
        return authorService.getList();
    }

    @Override
    public List<AuthorDto> getAuthorListByName(String mask) {
        return authorService.getListByName(mask);
    }

    @Override
    public String addAuthor(AuthorDto dto) {
        return authorService.add(dto);
    }

    @Override
    public void deleteAuthor(String id) {
        authorService.delete(id);
    }
}
