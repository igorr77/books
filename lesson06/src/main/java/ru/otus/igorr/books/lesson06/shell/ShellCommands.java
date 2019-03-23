package ru.otus.igorr.books.lesson06.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

@ShellComponent
public class ShellCommands {

    private boolean isLoginDone = false;
    private boolean isProcessDone = false;
    private boolean isResultDone = false;


    @Autowired
    public ShellCommands() {
    }



    public Availability loginAvailability(){
        return isLoginDone ? Availability.available() : Availability.unavailable("User no login");
    }

    public Availability processAvailability(){
        return isProcessDone ? Availability.available() : Availability.unavailable("No processing");
    }

}
