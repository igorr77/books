package ru.otus.igorr.books.lesson18.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.dto.BookDto;
import ru.otus.igorr.books.lesson18.dto.NoteDto;
import ru.otus.igorr.books.lesson18.repository.book.BookReactiveRepository;

@Service
public class BookReactiveServiceImpl implements BookReactiveService {


    private final BookReactiveRepository bookRepository;

    @Autowired
    public BookReactiveServiceImpl(BookReactiveRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Mono<BookDto> get(String id) {
        return null;
    }

    @Override
    public Flux<BookDto> getList() {
        return null;
    }

    @Override
    public Mono<BookDto> add(BookDto dto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Mono<NoteDto> getNote(String noteId) {
        return null;
    }

    @Override
    public Flux<NoteDto> getNoteList(String bookId) {
        return null;
    }

    @Override
    public Mono<NoteDto> addNote(NoteDto dto) {
        return null;
    }

    @Override
    public void deleteNote(String noteId) {

    }
}
