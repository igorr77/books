package ru.otus.igorr.books.lesson14.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.igorr.books.lesson14.dto.AuthorDto;
import ru.otus.igorr.books.lesson14.dto.GenreDto;
import ru.otus.igorr.books.lesson14.service.author.AuthorService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ShellComponent
public class AuthorCommands {


    private static final String OFFSET = "--------------------------\n\n";
    private final AuthorService authorService;


    @Autowired
    public AuthorCommands(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ShellMethod(key = "authorList", value = "Show author list")
    public String authorList() {

        List<AuthorDto> list = authorService.getListAll();

        System.out.println();
        return OFFSET + list.stream().map(a -> a.toString()).collect(Collectors.joining("\n"));
    }

    @ShellMethod(key = "authorLikeName", value = "Show author list by name")
    public String authorLikeName(@ShellOption("--mask") String mask) {

        List<AuthorDto> list = authorService.getListByName(mask);

        System.out.println();
        return OFFSET + list.stream().map(a -> a.toString()).collect(Collectors.joining("\n"));
    }

    @ShellMethod(key = "authorAdd", value = "Add author")
    public String authorAdd(@ShellOption("--firstName") String firstName,
                            @ShellOption("--lastName") String lastName,
                            @ShellOption("--surtName") String surName,
                            @ShellOption("--genresId") String genreId
    ) {

        List<String> genreIds = Arrays.asList(genreId);
        List<GenreDto> genreList = genreIds.stream()
                .map(id -> {
                    return new GenreDto(id, null, null);
                })
                .collect(Collectors.toList());

        AuthorDto author = new AuthorDto(null, firstName, lastName, surName, genreList, null);

        authorService.add(author);

        List<AuthorDto> list = authorService.getListByName(firstName + ".*");

        System.out.println();
        return OFFSET + list.stream().map(a -> a.toString()).collect(Collectors.joining("\n"));
    }

    @ShellMethod(key = "authorDel", value = "Delete author")
    public String authorDel(@ShellOption("--authorId") String id) {

        authorService.delete(id);


        List<AuthorDto> list = authorService.getListAll();

        System.out.println();
        return OFFSET + list.stream().map(a -> a.toString()).collect(Collectors.joining("\n"));
    }


    // TODO: 20.04.19


}
