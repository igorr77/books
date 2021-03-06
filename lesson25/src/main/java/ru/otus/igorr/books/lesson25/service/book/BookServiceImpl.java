package ru.otus.igorr.books.lesson25.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson25.domain.mongo.author.Author;
import ru.otus.igorr.books.lesson25.domain.mongo.book.Book;
import ru.otus.igorr.books.lesson25.domain.mongo.book.Note;
import ru.otus.igorr.books.lesson25.dto.AuthorDto;
import ru.otus.igorr.books.lesson25.dto.BookDto;
import ru.otus.igorr.books.lesson25.dto.DtoConverter;
import ru.otus.igorr.books.lesson25.dto.NoteDto;
import ru.otus.igorr.books.lesson25.execptions.GenreMismatchException;
import ru.otus.igorr.books.lesson25.repository.mongo.author.AuthorRepository;
import ru.otus.igorr.books.lesson25.repository.mongo.book.BookRepository;
import ru.otus.igorr.books.lesson25.repository.mongo.book.NoteRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final NoteRepository noteRepository;
    private final AuthorRepository authorRepository;
    private final DtoConverter<Book, BookDto> bookConverter;
    private final DtoConverter<Note, NoteDto> noteConverter;
    private final DtoConverter<Author, AuthorDto> authorConverter;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository,
                           NoteRepository noteRepository,
                           AuthorRepository authorRepository,
                           @Qualifier("bookConverter") DtoConverter bookConverter,
                           @Qualifier("noteConverter") DtoConverter noteConverter,
                           @Qualifier("authorConverter") DtoConverter authorConverter
    ) {
        this.bookRepository = bookRepository;
        this.noteRepository = noteRepository;
        this.authorRepository = authorRepository;
        this.bookConverter = bookConverter;
        this.noteConverter = noteConverter;
        this.authorConverter = authorConverter;
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
                        .filter(author -> !authorConverter.convert(authorRepository.findById(author.getId()).orElse(Author.empty()))
                                .getGenreList()
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

        List<BookDto> dtoList =
                bookList.stream()
                        .map(book -> {
                            BookDto dto = bookConverter.convert(book);
                            boolean isNote = noteRepository.countByBookId(book.getId()) != 0;
                            dto.setIsNote(isNote);
                            return dto;
                        })
                        .collect(Collectors.toList());
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
        return noteRepository.findByBookId(bookId)
                .stream()
                .map(note -> noteConverter.convert(note))
                .collect(Collectors.toList());
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
