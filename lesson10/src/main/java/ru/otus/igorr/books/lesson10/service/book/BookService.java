package ru.otus.igorr.books.lesson10.service.book;

import ru.otus.igorr.books.lesson10.dto.BookDto;
import ru.otus.igorr.books.lesson10.dto.GenreDto;
import ru.otus.igorr.books.lesson10.dto.NoteDto;

import java.util.List;

public interface BookService {
    void add(BookDto dto);
    void addNote(NoteDto dto);
    List<BookDto> getList();
}
