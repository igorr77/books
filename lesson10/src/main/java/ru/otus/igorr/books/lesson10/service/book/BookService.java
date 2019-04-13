package ru.otus.igorr.books.lesson10.service.book;

import ru.otus.igorr.books.lesson10.dto.BookDto;
import ru.otus.igorr.books.lesson10.dto.NoteDto;

import java.util.List;

public interface BookService {
    BookDto getById(long id);
    void add(BookDto dto);
    List<BookDto> getList();

    NoteDto addNote(NoteDto dto);
}
