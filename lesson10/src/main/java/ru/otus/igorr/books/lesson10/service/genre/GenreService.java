package ru.otus.igorr.books.lesson10.service.genre;

import ru.otus.igorr.books.lesson10.dto.GenreDto;

import java.util.List;

public interface GenreService {
    GenreDto getById(long id);
    void add(GenreDto genre);
    List<GenreDto> getList();
}
