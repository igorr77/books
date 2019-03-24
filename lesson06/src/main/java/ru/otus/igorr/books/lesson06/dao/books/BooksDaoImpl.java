package ru.otus.igorr.books.lesson06.dao.books;

import ru.otus.igorr.books.lesson06.domain.Book;

import java.util.List;
import java.util.Optional;

public class BooksDaoImpl implements BooksDao {
    @Override
    public Optional<Book> get(int id) {
        return Optional.empty();
    }

    @Override
    public int save(Book entity) {
        return 0;
    }

    @Override
    public int delete(Book entity) {
        return 0;
    }

    @Override
    public List<Book> getList(String condition) {
        return null;
    }
}
