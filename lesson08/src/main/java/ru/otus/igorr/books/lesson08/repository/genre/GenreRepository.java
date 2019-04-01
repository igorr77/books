package ru.otus.igorr.books.lesson08.repository.genre;

import ru.otus.igorr.books.lesson08.domain.genre.Genre;

import java.util.List;

public interface GenreRepository {
    Genre getById(int id);

    void save(Genre genre);

    List<Genre> getList();

    void delete(Genre genre);

}
