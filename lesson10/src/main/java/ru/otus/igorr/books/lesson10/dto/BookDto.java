package ru.otus.igorr.books.lesson10.dto;

import lombok.Getter;
import lombok.Setter;
import ru.otus.igorr.books.lesson10.domain.author.Author;
import ru.otus.igorr.books.lesson10.domain.book.Note;
import ru.otus.igorr.books.lesson10.domain.genre.Genre;

import java.util.List;

@Getter
@Setter
public class BookDto {
    private long id;
    private String title;
    private List<AuthorDto> authorDtoList;
    private GenreDto genreDto;
    private String description;
    private List<NoteDto> noteDtoList;
}
