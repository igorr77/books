package ru.otus.igorr.books.lesson12.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson12.domain.book.Book;
import ru.otus.igorr.books.lesson12.domain.book.Note;
import ru.otus.igorr.books.lesson12.dto.BookDto;
import ru.otus.igorr.books.lesson12.dto.BookDtoConverter;
import ru.otus.igorr.books.lesson12.dto.DtoConverter;
import ru.otus.igorr.books.lesson12.dto.NoteDto;
import ru.otus.igorr.books.lesson12.repository.book.BookRepository;
import ru.otus.igorr.books.lesson12.repository.book.NoteRepository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final NoteRepository noteRepository;
    private final DtoConverter<Book, BookDto> bookConverter;
    private final DtoConverter<Note, NoteDto> noteConverter;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository,
                           NoteRepository noteRepository,
                           @Qualifier("bookConverter") DtoConverter bookConverter,
                           @Qualifier("noteConverter") DtoConverter noteConverter
    ) {
        this.bookRepository = bookRepository;
        this.noteRepository = noteRepository;
        this.bookConverter = bookConverter;
        this.noteConverter = noteConverter;
    }


    @Override
    public BookDto getById(String id) {
        Book book = bookRepository.findById(id).orElse(new Book());
        List<String> noteIds = book.getNotes().stream().map(n -> n.getId()).collect(Collectors.toList());
        List<Note> notes = StreamSupport.stream(noteRepository.findAllById(noteIds).spliterator(), false)
                .collect(Collectors.toList());
        book.setNotes(notes);
        return bookConverter.convert(book);
    }

    @Override
    public String add(BookDto dto) {
        Book book = bookConverter.fill(dto);
        Book saveBook = bookRepository.save(book);
        return saveBook.getId();
    }

    @Override
    public List<BookDto> getList() {

        List<Book> bookList = bookRepository.findAll();

        bookList.forEach(book -> {

            List<String> noteIds = Optional.ofNullable(book.getNotes()).orElse(Collections.emptyList())
                    .stream()
                    .map(n -> n.getId())
                    .collect(Collectors.toList());
            List<Note> notes = StreamSupport.stream(noteRepository.findAllById(noteIds).spliterator(), false)
                    .collect(Collectors.toList());

            book.setNotes(notes);
        });

        List<BookDto> dtoList = new ArrayList<>();
        bookList.forEach(e -> dtoList.add(((BookDtoConverter) bookConverter).convert(e)));

        return dtoList;
    }

    @Override
    public NoteDto addNote(NoteDto dto) {
        Note note = noteRepository.save(noteConverter.fill(dto));
        return noteConverter.convert(note);
    }

    @Override
    public void delete(String id) {
        bookRepository.deleteById(id);
    }
}
