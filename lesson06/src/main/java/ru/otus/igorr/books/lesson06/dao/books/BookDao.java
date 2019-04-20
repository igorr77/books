package ru.otus.igorr.books.lesson06.dao.books;

import ru.otus.igorr.books.lesson06.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    Optional<Book> get(int id);

    /**
     * Сохранение сущности
     *
     * @param book
     * @return 0 - ошибка при сохранении, !0 - id
     */
    int save(Book book);

    /**
     * @param book
     * @return Колличество удаленных записей
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
