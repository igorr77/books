package ru.otus.igorr.books.lesson18.dto;

import java.util.List;

public interface DtoConverter<T, M> {
    M convert(T entity);

    T fill(M dto);

    List<M> convertList(List<T> list);

    List<T> fillList(List<M> list);
}
