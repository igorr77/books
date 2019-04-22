package ru.otus.igorr.books.lesson12.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import ru.otus.igorr.books.lesson12.service.author.AuthorService;

@ShellComponent
public class AuthorCommands {


    private final AuthorService authorService;


    @Autowired
    public AuthorCommands(AuthorService authorService) {
        this.authorService = authorService;
    }

    // TODO: 20.04.19

}
