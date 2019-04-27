package ru.otus.igorr.books.lesson08.dto;

public interface DtoConverter <T, M> {
    M convert(T entity);
    T fill(M dto);
}
