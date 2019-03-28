package ru.otus.igorr.books.lesson06.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.igorr.books.lesson06.domain.Book;
import ru.otus.igorr.books.lesson06.services.book.BookService;

import java.util.List;

@ShellComponent
public class BookCommands {


    private final BookService bookService;

    @Autowired
    public BookCommands(BookService bookService) {
        this.bookService = bookService;
    }


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
