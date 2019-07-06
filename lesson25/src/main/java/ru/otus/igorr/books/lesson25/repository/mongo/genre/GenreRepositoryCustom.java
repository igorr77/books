package ru.otus.igorr.books.lesson25.repository.mongo.genre;

import ru.otus.igorr.books.lesson25.domain.mongo.genre.Genre;

import java.util.List;

public interface GenreRepositoryCustom {
    List<Genre> findByNameLike(String regexk);
}
