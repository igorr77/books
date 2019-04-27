package ru.otus.igorr.books.lesson12.repository.author;

import ru.otus.igorr.books.lesson12.domain.author.Author;

import java.util.List;

public interface AuthorRepositoryCustom {
    List<Author> findByNameLike(String regex);

    List<Author> findByGenreId(String genreId);
}
