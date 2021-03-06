package ru.otus.igorr.books.lesson10.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.igorr.books.lesson10.domain.author.Author;
import ru.otus.igorr.books.lesson10.domain.genre.Genre;
import ru.otus.igorr.books.lesson10.dto.AuthorDto;
import ru.otus.igorr.books.lesson10.dto.BookDto;
import ru.otus.igorr.books.lesson10.service.book.BookService;
import ru.otus.igorr.books.lesson10.service.genre.GenreService;

import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class BookCommands {


    private final BookService bookService;
    private final GenreService genreService;

    @Autowired
    public BookCommands(BookService bookService, GenreService genreService) {
        this.bookService = bookService;
        this.genreService = genreService;
    }

    @ShellMethod(key = "bookAdd", value = "Add book entity")
    public void genreInsert(@ShellOption("--title") String title,
                            @ShellOption("--authorId") long authorId,
                            @ShellOption("--genreId") long genreId,
                            @ShellOption("--desc") String description

    ) {
        BookDto dto = new BookDto();
        List<AuthorDto> authorList = new ArrayList();
        AuthorDto author = new AuthorDto();

        dto.setTitle(title);
        dto.setAuthorList(authorList);
        dto.setTitle(title);


        //Genre genre = genreService.getById(genreId);
        //dto.setGenre(genre);


        dto.setDescription(description);
        bookService.add(dto);
    }


    @ShellMethod(key = "bookList", value = "Show book list")
    public void bookList() {

        List<BookDto> list = bookService.getList();

        int breakPoint = 0;

        list.forEach(System.out::println);
    }

}
