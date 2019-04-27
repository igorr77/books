package ru.otus.igorr.books.lesson12.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.igorr.books.lesson12.dto.AuthorDto;
import ru.otus.igorr.books.lesson12.dto.BookDto;
import ru.otus.igorr.books.lesson12.dto.GenreDto;
import ru.otus.igorr.books.lesson12.service.book.BookService;
import ru.otus.igorr.books.lesson12.service.genre.GenreService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ShellComponent
public class BookCommands {

    private static final String OFFSET = "----------------------------\n\n";

    private final BookService bookService;
    private final GenreService genreService;

    @Autowired
    public BookCommands(BookService bookService, GenreService genreService) {
        this.bookService = bookService;
        this.genreService = genreService;
    }

    @ShellMethod(key = "bookList", value = "Show book list")
    public String bookList() {

        List<BookDto> list = bookService.getList();
        return OFFSET + list.stream().map(book -> book.toString()).collect(Collectors.joining("\n"));
    }

    @ShellMethod(key = "bookDel", value = "Delete book by id")
    public String bookDel(@ShellOption("-- bookId") String id) {

        bookService.delete(id);

        List<BookDto> list = bookService.getList();
        return OFFSET + list.stream().map(book -> book.toString()).collect(Collectors.joining("\n"));
    }

    @ShellMethod(key = "bookAdd", value = "Add book")
    public String bookAdd(@ShellOption("-- title") String title,
                          @ShellOption("-- authorId") String authorId,
                          @ShellOption("-- genreId") String genreId,
                          @ShellOption("-- description") String description
    ) {


        BookDto bookDto = new BookDto
                .Builder()
                .title(title)
                .authorList(Arrays.asList(new AuthorDto(authorId)))
                .genre(new GenreDto(genreId))
                .description(description)
                .build();

        bookService.add(bookDto);

        List<BookDto> list = bookService.getList();
        return OFFSET + list.stream().map(book -> book.toString()).collect(Collectors.joining("\n"));
    }

    // TODO: 20.04.19  
}
