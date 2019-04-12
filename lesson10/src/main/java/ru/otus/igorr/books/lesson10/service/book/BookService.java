package ru.otus.igorr.books.lesson10.service.book;

import ru.otus.igorr.books.lesson10.dto.BookDto;
import ru.otus.igorr.books.lesson10.dto.GenreDto;

import java.util.List;

public interface BookService {
    void add(BookDto genre);
    List<BookDto> getList();
}
