package ru.otus.igorr.books.lesson10.dto;

import ru.otus.igorr.books.lesson10.domain.author.Author;
import ru.otus.igorr.books.lesson10.domain.book.Book;
import ru.otus.igorr.books.lesson10.domain.book.Note;
import ru.otus.igorr.books.lesson10.domain.genre.Genre;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BookDtoConverter implements DtoConverter<Book, BookDto> {
    @Override
    public BookDto convert(Book book) {
        BookDto dto = new BookDto();

        if (book != null) {
            List<Author> authorList = Optional.ofNullable(book.getAuthorList()).orElse(Collections.emptyList());
            Genre genre = book.getGenre();
            List<Note> noteList = book.getNoteList();

            dto.setId(book.getId());
            dto.setTitle(book.getTitle());
            dto.setAuthorList(authorList);
            dto.setGenre(genre);
            dto.setDescription(book.getDescription());
            dto.setNoteList(noteList);
        } else {
            dto.setId(-1L);
        }

        return dto;
    }

    @Override
    public Book fill(BookDto dto) {
        return null;
    }
}
