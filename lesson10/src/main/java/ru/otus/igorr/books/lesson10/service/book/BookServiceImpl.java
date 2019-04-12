package ru.otus.igorr.books.lesson10.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson10.domain.book.Book;
import ru.otus.igorr.books.lesson10.dto.*;
import ru.otus.igorr.books.lesson10.repository.book.BookRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final DtoConverter<Book, BookDto> converter;

    @Autowired
    public BookServiceImpl(BookRepository repository,
                           @Qualifier("bookConverter") DtoConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public void add(BookDto dto) {
        Book book = repository.save(converter.fill(dto));
        int breakPoint = 0;
    }

    @Override
    public List<BookDto> getList() {

        List<Book> bookList = repository.findAll();

        List<BookDto> dtoList = new ArrayList<>();
        bookList.forEach(e -> dtoList.add(((BookDtoConverter) converter).convert(e)));

        return dtoList;
    }

}
