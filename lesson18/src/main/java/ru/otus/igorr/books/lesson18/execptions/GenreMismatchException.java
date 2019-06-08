package ru.otus.igorr.books.lesson18.execptions;

public class GenreMismatchException extends RuntimeException {

    private String entity;

    public GenreMismatchException(String entity) {
        this.entity = entity;
    }

    @Override
    public String getMessage() {
        return "Discrepancy of genres at the connected entities with id: " + entity;
    }
}
