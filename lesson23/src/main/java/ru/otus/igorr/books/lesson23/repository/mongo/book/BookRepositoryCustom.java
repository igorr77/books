package ru.otus.igorr.books.lesson23.repository.mongo.book;

import ru.otus.igorr.books.lesson23.domain.mongo.book.Book;

import java.util.List;

public interface BookRepositoryCustom {
    List<Book> findByAuthorId(String authorId);

    List<Book> findByGenreId(String genreId);

    boolean existsAuthor(String authorId);
}
