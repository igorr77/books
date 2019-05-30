package ru.otus.igorr.books.lesson15.repository.genre;

import ru.otus.igorr.books.lesson15.domain.genre.Genre;

import java.util.List;

public interface GenreRepositoryCustom {
    List<Genre> findByNameLike(String regexk);
}
