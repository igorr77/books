package ru.otus.igorr.books.lesson06.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.igorr.books.lesson06.domain.Author;
import ru.otus.igorr.books.lesson06.services.author.AuthorService;

import java.util.List;

@ShellComponent
public class AuthorCommands {


    private final AuthorService authorService;

    @Autowired
    public AuthorCommands(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ShellMethod(key = "authorInsert", value = "Add Author object")
    public void authorInsert(@ShellOption("--name") String name, @ShellOption("--desc") String description) {
        Author author = new Author();
        author.setFirstName("FirstName");
        author.setSurName("SurName");
        author.setLastName("LastName");
        author.setCountry("ABC");
        authorService.save(author);
        System.out.println(author.toString());
    }


    @ShellMethod(key = "authorGet", value = "Show Author object")
    public void authorGet(@ShellOption("id") int id) {
        Author author = authorService.get(id);
        System.out.println(author.toString());
    }

    @ShellMethod(key = "authorDel", value = "Delete Author object by id")
    public void authorDelete(@ShellOption("id") int id) {
        Author author = new Author();
        author.setId(id);
        int rowCount = authorService.delete(author);
        System.out.println("Deleted rows:" + rowCount);
    }

    @ShellMethod(key = "authorList", value = "Show author list")
    public void authorList() {
        List<Author> authorList = authorService.getList("");
        authorList.forEach(System.out::println);
    }

}
