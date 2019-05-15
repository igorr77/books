package ru.otus.igorr.books.lesson15.repository.book;

import ru.otus.igorr.books.lesson15.domain.book.Note;

import java.util.List;

public interface NoteRepositoryCustom {
    List<Note> findByBookId(String bookId);

    void deleteByBookId(String bookId);
}
