package ru.otus.igorr.books.lesson10.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookDto {
    private long id;
    private String title;
    private List<AuthorDto> authorList;
    private GenreDto genreDto;
    private String description;
    private List<NoteDto> noteList;
}
