package ru.otus.igorr.books.lesson08.repository.genre;

import ru.otus.igorr.books.lesson08.domain.genre.Genre;

public interface GenreRepository {
    Genre getById(int id);

    int save(Genre genre);
}
