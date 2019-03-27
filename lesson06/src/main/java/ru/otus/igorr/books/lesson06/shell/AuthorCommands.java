package ru.otus.igorr.books.lesson06.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import ru.otus.igorr.books.lesson06.services.author.AuthorService;
import ru.otus.igorr.books.lesson06.services.book.BookService;
import ru.otus.igorr.books.lesson06.services.genre.GenreService;

@ShellComponent
public class AuthorCommands {


    private final GenreService genreService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public AuthorCommands(GenreService genreService, AuthorService authorService, BookService bookService) {
        this.genreService = genreService;
        this.authorService = authorService;
        this.bookService = bookService;
    }


    // TODO: 26.03.19 Author


}
