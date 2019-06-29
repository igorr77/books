package ru.otus.igorr.books.lesson23.shell;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.igorr.books.lesson23.domain.genre.Genre;
import ru.otus.igorr.books.lesson23.repository.genre.GenreH2Repository;
import ru.otus.igorr.books.lesson23.repository.genre.GenreRepository;

import java.util.List;

@Slf4j
@ShellComponent
public class MongoCommands {

    @Autowired
    GenreRepository repository;

    /* Util */
    @ShellMethod(key = "listM", value = "Mongo findAll")
    public void findAll() {

        List<Genre> list = repository.findAll();
        list.stream()
                .forEach(System.out::println);


    }


}
