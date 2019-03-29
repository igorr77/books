package ru.otus.igorr.books.lesson06.dao.author;

import ru.otus.igorr.books.lesson06.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    Optional<Author> get(int id);

    /**
     * Сохранение сущности
     *
     * @param author
     * @return 0 - ошибка при сохранении, !0 - entityId
     */
    int save(Author author);

    /**
     * @param author
     * @return Колличество удаленных записей
     */
    int delete(Author author);

    /**
     * @param condition
     * @return
     */
    List<Author> getList(String condition);

    /**
     * @return
     */
    int getMaxId();

}
