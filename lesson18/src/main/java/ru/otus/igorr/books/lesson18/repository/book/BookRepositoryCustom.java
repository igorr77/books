package ru.otus.igorr.books.lesson18.repository.book;

import ru.otus.igorr.books.lesson18.domain.book.Book;

import java.util.List;

public interface BookRepositoryCustom {
    List<Book> findByAuthorId(String authorId);

    List<Book> findByGenreId(String genreId);

    boolean existsAuthor(String authorId);
}
