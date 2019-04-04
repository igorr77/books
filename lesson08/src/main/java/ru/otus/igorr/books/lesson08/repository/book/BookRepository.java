package ru.otus.igorr.books.lesson08.repository.book;

import ru.otus.igorr.books.lesson08.domain.book.Book;
import ru.otus.igorr.books.lesson08.domain.book.Note;
import ru.otus.igorr.books.lesson08.dto.BookDto;

import java.util.List;

public interface BookRepository {
    BookDto getById(int id);

    int save(Book book);

    List<Book> getList();

    void delete(Book book);

    void addNote(Book book, Note note);
}
