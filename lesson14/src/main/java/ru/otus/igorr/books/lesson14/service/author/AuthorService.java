package ru.otus.igorr.books.lesson14.service.author;

import ru.otus.igorr.books.lesson14.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    AuthorDto get(String id);

    String add(AuthorDto dto);

    List<AuthorDto> getList();

    List<AuthorDto> getListByName(String mask);

    void delete(String id);
}
