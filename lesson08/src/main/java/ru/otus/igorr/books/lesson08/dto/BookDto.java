package ru.otus.igorr.books.lesson08.dto;

import lombok.Getter;
import lombok.Setter;
import ru.otus.igorr.books.lesson08.domain.author.Author;
import ru.otus.igorr.books.lesson08.domain.book.Note;
import ru.otus.igorr.books.lesson08.domain.genre.Genre;

import java.util.List;

@Getter
@Setter
public class BookDto {
    private int id;
    private String title;
    private List<Author> authorList;
    private Genre genre;
    private String description;
    private List<Note> noteList;
}
