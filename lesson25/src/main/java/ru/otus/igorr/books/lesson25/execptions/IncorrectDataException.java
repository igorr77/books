package ru.otus.igorr.books.lesson25.execptions;

public class IncorrectDataException extends RuntimeException {


    @Override
    public String getMessage() {
        return "Incorrect data from UI";
    }
}
