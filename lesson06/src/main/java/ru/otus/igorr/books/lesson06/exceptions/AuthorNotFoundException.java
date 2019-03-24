package ru.otus.igorr.books.lesson06.exceptions;

public class AuthorNotFoundException extends RuntimeException {

    private final int id;

    public AuthorNotFoundException(int id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Author with id = " + id + " not found";
    }
}