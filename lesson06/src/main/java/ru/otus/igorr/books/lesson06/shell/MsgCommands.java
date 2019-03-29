package ru.otus.igorr.books.lesson06.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.igorr.books.lesson06.services.message.MessageSources;

@ShellComponent
public class MsgCommands {


    private final MessageSources service;

    @Autowired
    public MsgCommands(MessageSources service) {
        this.service = service;
    }

    @ShellMethod(key = "getMsg", value = "Test messageSources")
    public void getMessage() {
        System.out.println(service.getMessage("welcome"));
    }

}
