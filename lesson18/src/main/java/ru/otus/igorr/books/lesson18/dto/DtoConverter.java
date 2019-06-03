package ru.otus.igorr.books.lesson18.dto;

import java.util.List;

public interface DtoConverter<T, M> {
    M convert(T entity);

    T fill(M dto);

    @Deprecated
    List<M> convertList(List<T> list);

    @Deprecated
    List<T> fillList(List<M> list);
}
