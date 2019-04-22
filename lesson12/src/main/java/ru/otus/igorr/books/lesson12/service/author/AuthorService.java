package ru.otus.igorr.books.lesson12.service.author;

import ru.otus.igorr.books.lesson12.domain.author.Author;
import ru.otus.igorr.books.lesson12.dto.AuthorDto;
import ru.otus.igorr.books.lesson12.dto.BookDto;

import java.util.List;

public interface AuthorService {
    Author add(AuthorDto dto);
    AuthorDto getById(String id);
    List<AuthorDto> getByBook(BookDto book);

    List<AuthorDto> getListWithoutBooks();
    List<AuthorDto> getListWithBooks();
}
