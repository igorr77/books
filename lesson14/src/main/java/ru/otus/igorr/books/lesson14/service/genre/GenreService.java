package ru.otus.igorr.books.lesson14.service.genre;

import ru.otus.igorr.books.lesson14.dto.GenreDto;

import java.util.List;

public interface GenreService {
    GenreDto getById(String id);

    String add(GenreDto genre);

    void delete(String id);

    void delete(GenreDto dto);

    List<GenreDto> getList();

    List<GenreDto> getListByName(String mask);
}
