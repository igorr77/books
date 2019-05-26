package ru.otus.igorr.books.lesson18.service.genre;

import ru.otus.igorr.books.lesson18.dto.GenreDto;

import java.util.List;

public interface GenreService {
    GenreDto get(String id);

    String add(GenreDto genre);

    void delete(String id);

    void delete(GenreDto dto);

    List<GenreDto> getList();

    List<GenreDto> getListByName(String mask);
}
