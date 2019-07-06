package ru.otus.igorr.books.lesson25.repository.mongo.author;

import ru.otus.igorr.books.lesson25.domain.mongo.author.Author;

import java.util.List;

public interface AuthorRepositoryCustom {
    List<Author> findByNameLike(String regex);

    List<Author> findByGenreId(String genreId);

}
