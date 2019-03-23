package ru.otus.igorr.books.lesson06.exceptions;

public class GenreNotFoundException extends RuntimeException {

    private final int id;

    public GenreNotFoundException(int id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Genre with id = " + id + " not found";
    }
}