package ru.otus.igorr.books.lesson12.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import ru.otus.igorr.books.lesson12.service.book.BookService;
import ru.otus.igorr.books.lesson12.service.genre.GenreService;

@ShellComponent
public class BookCommands {


    private final BookService bookService;
    private final GenreService genreService;

    @Autowired
    public BookCommands(BookService bookService, GenreService genreService) {
        this.bookService = bookService;
        this.genreService = genreService;
    }


    // TODO: 20.04.19  
}
