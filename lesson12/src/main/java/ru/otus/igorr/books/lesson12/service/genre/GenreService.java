package ru.otus.igorr.books.lesson12.service.genre;

import ru.otus.igorr.books.lesson12.dto.GenreDto;

import java.util.List;

public interface GenreService {
    GenreDto getById(String id);
    String add(GenreDto genre);
    List<GenreDto> getList();
    List<GenreDto> getListByName(String mask);
}
