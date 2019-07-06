package ru.otus.igorr.books.lesson25.repository.mongo.book;

import ru.otus.igorr.books.lesson25.domain.mongo.book.Note;

import java.util.List;

public interface NoteRepositoryCustom {
    List<Note> findByBookId(String bookId);
    Long countByBookId(String bookId);
    void deleteByBookId(String bookId);
}
