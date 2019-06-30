package ru.otus.igorr.books.lesson23.shell;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.igorr.books.lesson23.batch.JobService;

@Slf4j
@ShellComponent
public class BatchCommands {


    @Autowired
    private JobService jobService;

    /* Util */
    @ShellMethod(key = "test", value = "Test util")
    public void testUtil(@ShellOption("--name") String name, @ShellOption("--desc") String description) {

        LOG.debug("***: " + name + " " + description);

    }

    @ShellMethod(key = "start", value = "Start Job")
    public void start(@ShellOption("--name") String name) {

        LOG.debug("*** JobStart: " + name);

        jobService.start(name);

    }

    @ShellMethod(key = "stop", value = "Stop Job")
    public void stop(@ShellOption("--name") String name) {

        LOG.debug("*** Job Stop: " + name);

        jobService.restart(name);

    }
    @ShellMethod(key = "restart", value = "ReStart Job")
    public void restart(@ShellOption("--name") String name) {

        LOG.debug("*** Job ReStart: " + name);

        jobService.restart(name);

    }




}
