package ru.otus.igorr.books.lesson12.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookDto {
    private String id;
    private String title;
    private List<AuthorDto> authorList;
    private GenreDto genreDto;
    private String description;
    private List<NoteDto> noteList;
}
