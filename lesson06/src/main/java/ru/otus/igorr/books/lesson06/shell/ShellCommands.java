package ru.otus.igorr.books.lesson06.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.igorr.books.lesson06.domain.Book;
import ru.otus.igorr.books.lesson06.domain.Genre;
import ru.otus.igorr.books.lesson06.services.dao.AuthorService;
import ru.otus.igorr.books.lesson06.services.dao.BookService;
import ru.otus.igorr.books.lesson06.services.dao.GenreService;

import java.util.List;

@ShellComponent
public class ShellCommands {


    private final GenreService genreService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public ShellCommands(GenreService genreService, AuthorService authorService, BookService bookService) {
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

    // TODO: 26.03.19 Author

    // TODO: 26.03.19 Books
    /* Books*/
    @ShellMethod(key = "bookInsert", value = "Add Book object")
    public void bookInsert(@ShellOption(value = "--authorId", defaultValue = "1") int authorId,
                           @ShellOption(value = "--genreId", defaultValue = "1") int genreId,
                           @ShellOption(value = "--title", defaultValue = "Title") String title,
                           @ShellOption(value = "--isbn", defaultValue = "1234567890123") String isbn,
                           @ShellOption(value = "--pages", defaultValue = "99") int pages,
                           @ShellOption(value = "--desc", defaultValue = "Description Shell") String desc) {
        Book book = new Book();
        book.setAuthorId(authorId);
        book.setGenreId(genreId);
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPages(pages);
        book.setDescription(desc);
        bookService.save(book);
        System.out.println(book.toString());
    }


    @ShellMethod(key = "bookDel", value = "Delete Book object by id")
    public void bookDelete(@ShellOption("id") int id) {
        Book book = new Book();
        book.setId(id);
        int rowCount = bookService.delete(book);
        System.out.println("Deleted rows:" + rowCount);
    }

    @ShellMethod(key = "bookList", value = "Show book list")
    public void bookList() {
        List<Book> bookList = bookService.getList("");
        bookList.forEach(System.out::println);
    }


}
