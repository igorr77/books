package ru.otus.igorr.books.lesson06.exceptions;

public class BookNotFoundException extends RuntimeException {

    private final int id;

    public BookNotFoundException(int id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Book with id = " + id + " not found";
    }
}