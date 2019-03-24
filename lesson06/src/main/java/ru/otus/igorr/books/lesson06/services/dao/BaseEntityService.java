package ru.otus.igorr.books.lesson06.services.dao;

import java.util.List;

public interface BaseEntityService<T> {
    T get(int id);

    int save(T entity);

    int delete(T entity);

    List<T> getList(String condition);
}
