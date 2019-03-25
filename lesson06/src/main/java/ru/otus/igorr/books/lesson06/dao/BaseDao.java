package ru.otus.igorr.books.lesson06.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDao<T> {

    Optional<T> get(int id);

    /**
     * Сохранение сущности
     *
     * @param entity
     * @return 0 - ошибка при сохранении, !0 - entityId
     */
    int save(T entity);

    /**
     * @param entity
     * @return Колличество удаленных записей
     */
    int delete(T entity);

    /**
     * @param condition
     * @return
     */
    List<T> getList(String condition);

    /**
     * @return
     */
    int max();
}
