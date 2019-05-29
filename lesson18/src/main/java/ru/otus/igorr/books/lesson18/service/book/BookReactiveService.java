package ru.otus.igorr.books.lesson18.service.book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.dto.BookDto;
import ru.otus.igorr.books.lesson18.dto.NoteDto;

public interface BookReactiveService {
    /* Book */
    Mono<BookDto> get(String id);

    Flux<BookDto> getList();

    Mono<BookDto> add(BookDto dto);

    void delete(String id);

    /* Note */
    Mono<NoteDto> getNote(String noteId);

    Flux<NoteDto> getNoteList(String bookId);

    Mono<NoteDto> addNote(NoteDto dto);

    void deleteNote(String noteId);

}
