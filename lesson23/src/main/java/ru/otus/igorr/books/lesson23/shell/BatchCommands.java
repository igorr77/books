package ru.otus.igorr.books.lesson23.shell;

import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@Slf4j
@ShellComponent
public class BatchCommands {


    /* Util */
    @ShellMethod(key = "test", value = "Test util")
    public void testUtil(@ShellOption("--name") String name, @ShellOption("--desc") String description) {

        LOG.debug("***: " + name + " " + description);

    }


}
