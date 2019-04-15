package ru.otus.igorr.books.lesson10.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson10.domain.author.Author;
import ru.otus.igorr.books.lesson10.domain.book.Book;
import ru.otus.igorr.books.lesson10.domain.book.Note;
import ru.otus.igorr.books.lesson10.domain.genre.Genre;

import java.util.*;

import static ru.otus.igorr.books.lesson10.utils.Constant.NOT_FOUND_ENTITY_ID;

@Service("bookConverter")
public class BookDtoConverter implements DtoConverter<Book, BookDto> {

    private final DtoConverter<Author, AuthorDto> authorConverter;
    private final DtoConverter<Genre, GenreDto> genreConverter;
    private final DtoConverter<Note, NoteDto> noteConverter;

    @Autowired
    public BookDtoConverter(DtoConverter<Author, AuthorDto> authorConverter,
                            DtoConverter<Genre, GenreDto> genreConverter,
                            DtoConverter<Note, NoteDto> noteConverter) {
        this.authorConverter = authorConverter;
        this.genreConverter = genreConverter;
        this.noteConverter = noteConverter;
    }


    @Override
    public BookDto convert(Book book) {
        return entity2dto(book);
    }

    @Override
    public Book fill(BookDto dto) {
        return dto2entity(dto);
    }

    @Override
    public List<BookDto> convertList(List<Book> list) {
        return null;
    }

    @Override
    public List<Book> fillList(List<BookDto> list) {
        return null;
    }

    BookDto entity2dto(Book book) {
        BookDto dto = new BookDto();

        if (book != null) {

            List<Author> authorList = new ArrayList<>();
            authorList.addAll(Optional.of(book.getAuthors()).orElse(Collections.emptySet()));
            List<AuthorDto> authorDtoList = authorConverter.convertList(authorList);

            Genre genre = Optional.ofNullable(book.getGenre()).orElse(Genre.empty());

            List<Note> noteList = new ArrayList<>();
            noteList.addAll(Optional.ofNullable(book.getNotes()).orElse(Collections.emptySet()));
            List<NoteDto> noteDtoList = noteConverter.convertList(noteList);

            dto.setId(book.getId());
            dto.setTitle(book.getTitle());
            dto.setAuthorList(authorDtoList);
            dto.setGenreDto(genreConverter.convert(genre));
            dto.setDescription(book.getDescription());
            dto.setNoteList(noteDtoList);
        } else {
            dto.setId(NOT_FOUND_ENTITY_ID);
        }
        return dto;
    }

    Book dto2entity(BookDto dto) {
        Book book = new Book();

        book.setTitle(dto.getTitle());
        Set<Author> authors = new HashSet<>();
        dto.getAuthorList().forEach(authorDto ->
                authors.add(authorConverter.fill(authorDto))
        );
        book.setAuthors(authors);
        book.setGenre(genreConverter.fill(dto.getGenreDto()));

        book.setDescription(dto.getDescription());

        return book;
    }
}
