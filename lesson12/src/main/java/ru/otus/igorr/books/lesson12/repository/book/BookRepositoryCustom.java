package ru.otus.igorr.books.lesson12.repository.book;

import ru.otus.igorr.books.lesson12.domain.book.Book;

import java.util.List;

public interface BookRepositoryCustom {
    List<Book> findByAuthorId(String authorId);
    List<Book> findByGenreId(String genreId);
}
