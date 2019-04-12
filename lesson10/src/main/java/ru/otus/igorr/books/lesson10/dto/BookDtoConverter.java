package ru.otus.igorr.books.lesson10.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson10.domain.author.Author;
import ru.otus.igorr.books.lesson10.domain.book.Book;
import ru.otus.igorr.books.lesson10.domain.book.Note;
import ru.otus.igorr.books.lesson10.domain.genre.Genre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
            List<Author> authorList = Optional.ofNullable(book.getAuthorList()).orElse(Collections.emptyList());
            List<AuthorDto> authorDtoList = new ArrayList<>();

            Genre genre = book.getGenre();

            List<Note> noteList = book.getNoteList();
            List<NoteDto> noteDtoList = new ArrayList<>();
            noteList.forEach(note -> noteDtoList.add(noteConverter.convert(note)));

            dto.setId(book.getId());
            dto.setTitle(book.getTitle());
            dto.setAuthorDtoList(authorDtoList);
            dto.setGenreDto(genreConverter.convert(genre));
            dto.setDescription(book.getDescription());
            dto.setNoteDtoList(noteDtoList);
        } else {
            dto.setId(-1L);
        }
        return dto;
    }

    Book dto2entity(BookDto dto){
        Book book = new Book();

        // TODO: 12.04.2019

        return book;
    }
}
