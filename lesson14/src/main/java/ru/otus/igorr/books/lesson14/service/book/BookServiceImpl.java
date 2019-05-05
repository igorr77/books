package ru.otus.igorr.books.lesson14.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson14.domain.book.Book;
import ru.otus.igorr.books.lesson14.domain.book.Note;
import ru.otus.igorr.books.lesson14.dto.AuthorDto;
import ru.otus.igorr.books.lesson14.dto.BookDto;
import ru.otus.igorr.books.lesson14.dto.DtoConverter;
import ru.otus.igorr.books.lesson14.dto.NoteDto;
import ru.otus.igorr.books.lesson14.execptions.GenreMismatchException;
import ru.otus.igorr.books.lesson14.repository.book.BookRepository;
import ru.otus.igorr.books.lesson14.repository.book.NoteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
    public BookDto get(String id) {
        return bookConverter.convert(bookRepository.findById(id).orElse(Book.empty()));
    }

    @Override
    public String add(BookDto dto) {

        // проверяем на соответствие жанра книги и жанров авторов
        final String excludeGenreId = dto.getGenre().getId();
        List<AuthorDto> authors =
                dto.getAuthorList()
                        .stream()
                        .filter(author -> !author.getGenreList()
                                .stream()
                                .filter(genre -> genre.getId().equals(excludeGenreId))
                                .findFirst()
                                .isPresent())
                        .collect(Collectors.toList());
        if (authors.size() != 0) {
            throw new GenreMismatchException(authors.get(0).getId());
        }

        Book book = bookConverter.fill(dto);
        Book saveBook = bookRepository.save(book);
        return saveBook.getId();
    }

    @Override
    public List<BookDto> getList() {

        List<Book> bookList = bookRepository.findAll();

        List<BookDto> dtoList = new ArrayList<>();
        bookList.forEach(e -> dtoList.add(bookConverter.convert(e)));

        return dtoList;
    }

    @Override
    public void delete(String id) {
        List<Note> noteList = noteRepository.findByBookId(id);
        bookRepository.deleteById(id);
    }

    /* Note */

    @Override
    public NoteDto getNote(String noteId) {
        return noteConverter.convert(noteRepository.findById(noteId).orElse(Note.empty()));
    }

    @Override
    public List<NoteDto> getNoteList(String bookId) {
        return noteConverter.convertList(noteRepository.findByBookId(bookId));
    }

    @Override
    public NoteDto addNote(NoteDto dto) {
        Note note = noteRepository.save(noteConverter.fill(dto));
        return noteConverter.convert(note);
    }

    @Override
    public void deleteNote(String noteId) {
        noteRepository.deleteById(noteId);
    }


}
