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

    @ShellMethod(key = "start", value = "Start Job")
    public void start(@ShellOption("--name") String name) {

        LOG.debug("*** JobStart: " + name);

        jobService.start(name);

    }

    @ShellMethod(key = "listJob", value = "Job's list")
    public void listJob() {

        LOG.debug("*** Job's list: ");

        jobService.list().stream()
                .forEach(System.out::println);

    }


}
