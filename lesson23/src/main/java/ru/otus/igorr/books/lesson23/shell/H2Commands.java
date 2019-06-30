package ru.otus.igorr.books.lesson23.shell;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.igorr.books.lesson23.domain.jpa.genre.Genre;
import ru.otus.igorr.books.lesson23.repository.jpa.genre.GenreRepository;

import java.util.List;

@Slf4j
@ShellComponent
public class H2Commands {

    @Autowired
    @Qualifier("jenreJpaRepository")
    GenreRepository repository;

    /* Util */
    @ShellMethod(key = "listH", value = "H2 findAll")
    public void findAll() {

        List<Genre> list = repository.findAll();
        list.stream()
                .forEach(System.out::println);


    }


}
