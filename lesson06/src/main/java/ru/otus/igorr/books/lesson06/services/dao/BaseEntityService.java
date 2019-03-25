package ru.otus.igorr.books.lesson06.services.dao;

import java.util.List;

public interface BaseEntityService<T> {
    /**
     * @param id
     * @return
     */
    T get(int id);

    /**
     *
     * @param entity
     * @return
     */
    int save(T entity);

    /**
     *
     * @param entity
     * @return
     */
    int delete(T entity);

    /**
     *
     * @param condition
     * @return
     */
    List<T> getList(String condition);

    /**
     *
     * @return
     */
    int max();
}
