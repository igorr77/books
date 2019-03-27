package ru.otus.igorr.books.lesson06.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.igorr.books.lesson06.domain.Genre;
import ru.otus.igorr.books.lesson06.services.author.AuthorService;
import ru.otus.igorr.books.lesson06.services.book.BookService;
import ru.otus.igorr.books.lesson06.services.genre.GenreService;

import java.util.List;

@ShellComponent
public class GenreCommands {


    private final GenreService genreService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public GenreCommands(GenreService genreService, AuthorService authorService, BookService bookService) {
        this.genreService = genreService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    /* Genre */
    @ShellMethod(key = "genreInsert", value = "Add Genre object")
    public void genreInsert(@ShellOption("--name") String name, @ShellOption("--desc") String description) {
        Genre genre = new Genre(name, description);
        genreService.save(genre);
        System.out.println(genre.toString());
    }


    @ShellMethod(key = "genreGet", value = "Show Genre object")
    public void genreGet(@ShellOption("id") int id) {
        Genre genre = genreService.get(id);
        System.out.println(genre.toString());
    }

    @ShellMethod(key = "genreDel", value = "Delete Genre object by id")
    public void genreDelete(@ShellOption("id") int id) {
        Genre genre = new Genre();
        genre.setId(id);
        int rowCount = genreService.delete(genre);
        System.out.println("Deleted rows:" + rowCount);
    }

    @ShellMethod(key = "genreList", value = "Show genre list")
    public void genreList() {
        List<Genre> genreList = genreService.getList("");
        genreList.forEach(System.out::println);
    }


}
