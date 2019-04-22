package ru.otus.igorr.books.lesson12.service.book;

import ru.otus.igorr.books.lesson12.dto.BookDto;
import ru.otus.igorr.books.lesson12.dto.NoteDto;

import java.util.List;

public interface BookService {
    BookDto getById(String id);
    String add(BookDto dto);
    List<BookDto> getList();

    NoteDto addNote(NoteDto dto);
}
