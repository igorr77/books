package ru.otus.igorr.books.lesson10.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson10.domain.book.Book;
import ru.otus.igorr.books.lesson10.domain.book.Note;
import ru.otus.igorr.books.lesson10.dto.BookDto;
import ru.otus.igorr.books.lesson10.dto.BookDtoConverter;
import ru.otus.igorr.books.lesson10.dto.DtoConverter;
import ru.otus.igorr.books.lesson10.dto.NoteDto;
import ru.otus.igorr.books.lesson10.repository.book.BookRepository;
import ru.otus.igorr.books.lesson10.repository.book.NoteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


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
    public BookDto getById(long id) {
        Book book = bookRepository.findById(id).orElse(new Book());
        Set<Note> notes = noteRepository.findByBook(book);
        book.setNotes(notes);
        return bookConverter.convert(book);
    }

    @Override
    public long add(BookDto dto) {
        Book book = bookConverter.fill(dto);
        Book saveBook = bookRepository.saveAndFlush(book);
        return saveBook.getId();
    }

    @Override
    public List<BookDto> getList() {

        List<Book> bookList = bookRepository.findAll();

        bookList.forEach(book -> {
            Set<Note> notes = noteRepository.findByBook(book);
            book.setNotes(notes);
        });

        List<BookDto> dtoList = new ArrayList<>();
        bookList.forEach(e -> dtoList.add(((BookDtoConverter) bookConverter).convert(e)));

        return dtoList;
    }

    @Override
    public NoteDto addNote(NoteDto dto) {
        Note note = noteRepository.saveAndFlush(noteConverter.fill(dto));
        return noteConverter.convert(note);
    }
}
