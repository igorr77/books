package ru.otus.igorr.books.lesson22.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson22.domain.author.Author;
import ru.otus.igorr.books.lesson22.domain.book.Book;
import ru.otus.igorr.books.lesson22.domain.book.Note;
import ru.otus.igorr.books.lesson22.domain.genre.Genre;
import ru.otus.igorr.books.lesson22.utils.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("bookConverter")
public class BookDtoConverter implements DtoConverter<Book, BookDto> {

    private final DtoConverter<Author, AuthorDto> authorConverter;
    private final DtoConverter<Genre, GenreDto> genreConverter;
    private final DtoConverter<Note, NoteDto> noteConverter;

    @Autowired
    public BookDtoConverter(@Lazy DtoConverter<Author, AuthorDto> authorConverter,
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

    BookDto entity2dto(Book book) {
        BookDto dto = new BookDto();

        if (book != null) {

            List<Author> authorList = new ArrayList<>();
            authorList.addAll(Optional.of(book.getAuthors()).orElse(Collections.emptyList()));
            List<AuthorDto> authorDtoList = authorList
                    .stream()
                    .map(author -> authorConverter.convert(author))
                    .collect(Collectors.toList());

            Genre genre = Optional.ofNullable(book.getGenre()).orElse(Genre.empty());

            List<Note> noteList = new ArrayList<>();
            // TODO: 19.04.2019
            /*
            try {
                noteList.addAll(Optional.ofNullable(book.getNotes()).orElse(Collections.emptySet()));
            } catch (LazyInitializationException e) {
                noteList.addAll(Collections.emptySet());
            }
            */
            List<NoteDto> noteDtoList = noteList
                    .stream()
                    .map(note -> noteConverter.convert(note))
                    .collect(Collectors.toList());

            dto.setId(book.getId());
            dto.setTitle(book.getTitle());
            dto.setAuthorList(authorDtoList);
            dto.setGenre(genreConverter.convert(genre));
            dto.setDescription(book.getDescription());
            dto.setNoteList(noteDtoList);
        } else {
            dto.setId(Constant.NOT_FOUND_DOCUMENT_ID);
        }
        return dto;
    }

    Book dto2entity(BookDto dto) {
        Book book = new Book();

        book.setTitle(dto.getTitle());
        List<Author> authors =
                Optional.ofNullable(dto.getAuthorList()).orElse(Collections.emptyList()).stream()
                        .map(authorDto -> authorConverter.fill(authorDto))
                        .collect(Collectors.toList());

        book.setAuthors(authors);
        book.setGenre(genreConverter.fill(dto.getGenre()));

        book.setDescription(dto.getDescription());

        return book;
    }
}
