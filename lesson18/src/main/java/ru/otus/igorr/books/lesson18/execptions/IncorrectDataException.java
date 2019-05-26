package ru.otus.igorr.books.lesson18.execptions;

public class IncorrectDataException extends RuntimeException {


    @Override
    public String getMessage() {
        return "Incorrect data from UI";
    }
}
