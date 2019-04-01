package ru.otus.igorr.books.lesson08.repository.book;

import ru.otus.igorr.books.lesson08.domain.book.Book;
import ru.otus.igorr.books.lesson08.domain.book.Note;

import java.util.List;

public interface BookRepository {
    Book getById(int id);

    void save(Book book);

    List<Book> getList();

    void delete(Book book);

    void addNote(Book book, Note note);
}
