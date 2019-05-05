package ru.otus.igorr.books.lesson14.service.book;

import ru.otus.igorr.books.lesson14.dto.BookDto;
import ru.otus.igorr.books.lesson14.dto.NoteDto;

import java.util.List;

public interface BookService {
    /* Book */
    BookDto get(String id);

    List<BookDto> getList();

    String add(BookDto dto);

    void delete(String id);

    /* Note */
    NoteDto getNote(String noteId);

    List<NoteDto> getNoteList(String bookId);

    NoteDto addNote(NoteDto dto);

    void deleteNote(String noteId);

}
