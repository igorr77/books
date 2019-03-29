package ru.otus.igorr.books.lesson06.services.book;

import ru.otus.igorr.books.lesson06.domain.Book;

import java.util.List;

public interface BookService {
    /**
     * @param id
     * @return
     */
    Book get(int id);

    /**
     * @param book
     * @return
     */
    int save(Book book);

    /**
     * @param book
     * @return
     */
    int delete(Book book);

    /**
     * @param condition
     * @return
     */
    List<Book> getList(String condition);

    /**
     * @return
     */
    int getMaxId();
}
