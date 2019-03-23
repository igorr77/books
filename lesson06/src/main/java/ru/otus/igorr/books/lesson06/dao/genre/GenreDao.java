package ru.otus.igorr.books.lesson06.dao.genre;

import ru.otus.igorr.books.lesson06.domain.Genre;

import java.util.Optional;

public interface GenreDao {
    Optional<Genre> getById(int id);
    void insert(Genre genre);
    void update(Genre genre);
}
