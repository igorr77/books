package ru.otus.igorr.books.lesson18.execptions;

public class DeleteReferenceRecordException extends RuntimeException {
    private final String id;

    public DeleteReferenceRecordException(String id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "On record " + id + " is a reference";
    }
}
