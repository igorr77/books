package ru.otus.igorr.books.lesson23.service.book;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson23.domain.book.Book;
import ru.otus.igorr.books.lesson23.domain.book.Note;
import ru.otus.igorr.books.lesson23.dto.BookDto;
import ru.otus.igorr.books.lesson23.dto.DtoConverter;
import ru.otus.igorr.books.lesson23.dto.NoteDto;
import ru.otus.igorr.books.lesson23.repository.book.BookReactiveRepository;
import ru.otus.igorr.books.lesson23.repository.book.NoteReactiveRepository;

@Service
public class BookServiceImpl implements BookService {


    private final BookReactiveRepository bookRepository;
    private final NoteReactiveRepository noteRepository;
    private final DtoConverter<Book, BookDto> bookConverter;
    private final DtoConverter<Note, NoteDto> noteConverter;

    public BookServiceImpl(BookReactiveRepository bookRepository,
                           NoteReactiveRepository noteRepository,
                           DtoConverter<Book, BookDto> bookConverter,
                           DtoConverter<Note, NoteDto> noteConverter) {
        this.bookRepository = bookRepository;
        this.noteRepository = noteRepository;
        this.bookConverter = bookConverter;
        this.noteConverter = noteConverter;
    }

    @Override
    public Mono<BookDto> get(String id) {
        return bookRepository.findById(id)
                .map(book -> bookConverter.convert(book));
    }

    @Override
    public Flux<BookDto> getList() {
        return bookRepository.findAll()
                .map(book -> bookConverter.convert(book));
    }

    @Override
    public Mono<BookDto> add(BookDto bookDto) {
        return bookRepository.save(bookConverter.fill(bookDto))
                .map(book -> bookConverter.convert(book));
    }

    @Override
    public Mono<Void> delete(String id) {
        return bookRepository.deleteById(id);
    }

    @Override
    public Mono<NoteDto> getNote(String noteId) {
        return noteRepository.findById(noteId)
                .map(note -> noteConverter.convert(note));
    }

    @Override
    public Flux<NoteDto> getNoteList(String bookId) {
        return noteRepository.findAll()
                .map(note -> noteConverter.convert(note));
    }

    @Override
    public Mono<NoteDto> addNote(NoteDto noteDto) {
        return noteRepository.save(noteConverter.fill(noteDto))
                .map(note -> noteConverter.convert(note));
    }

    @Override
    public Mono<Void> deleteNote(String noteId) {
        return noteRepository.deleteById(noteId);
    }
}
