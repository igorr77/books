package ru.otus.igorr.books.lesson12.service.author;

import ru.otus.igorr.books.lesson12.dto.AuthorDto;
import ru.otus.igorr.books.lesson12.dto.BookDto;

import java.util.List;

public interface AuthorService {
    long add(AuthorDto dto);
    AuthorDto getById(long id);
    List<AuthorDto> getByBook(BookDto book);

    List<AuthorDto> getListWithoutBooks();
    List<AuthorDto> getListWithBooks();
}
