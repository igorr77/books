package ru.otus.igorr.books.lesson10.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.igorr.books.lesson10.dto.AuthorDto;
import ru.otus.igorr.books.lesson10.dto.BookDto;
import ru.otus.igorr.books.lesson10.dto.GenreDto;
import ru.otus.igorr.books.lesson10.service.author.AuthorService;
import ru.otus.igorr.books.lesson10.service.book.BookService;
import ru.otus.igorr.books.lesson10.service.genre.GenreService;

import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class AuthorCommands {


    private final AuthorService authorService;


    @Autowired
    public AuthorCommands(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ShellMethod(key = "authorAdd", value = "Add author entity")
    public void authorInsert(@ShellOption("--firstname") String firstName,
                             @ShellOption("--lastname") String lastName,
                             @ShellOption("--surname") String surName,
                             @ShellOption("--genreId") long genreId


    ) {
        AuthorDto author = new AuthorDto();
        List<GenreDto> genreList = new ArrayList<>();
        GenreDto genre = new GenreDto();
        genre.setId(genreId);

        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setSurName(surName);
        author.setGenreList(genreList);

        authorService.add(author);
    }

    @ShellMethod(key = "authorList", value = "Ahow author list")
    public void authorList() {
        List<AuthorDto> authorList = authorService.getList();
        authorList.forEach(System.out::println);
    }


}
