package ru.otus.igorr.books.lesson12.service.author;

import ru.otus.igorr.books.lesson12.domain.author.Author;
import ru.otus.igorr.books.lesson12.dto.AuthorDto;
import ru.otus.igorr.books.lesson12.dto.BookDto;

import java.util.List;

public interface AuthorService {
    AuthorDto getById(String id);
    String add(AuthorDto dto);

    List<AuthorDto> getListAll();

    List<AuthorDto> getListByName(String mask);

    void delete(String id);
}
