package ru.otus.igorr.books.lesson10.service.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson10.domain.author.Author;
import ru.otus.igorr.books.lesson10.domain.book.Book;
import ru.otus.igorr.books.lesson10.dto.AuthorDto;
import ru.otus.igorr.books.lesson10.dto.AuthorDtoConverter;
import ru.otus.igorr.books.lesson10.dto.BookDto;
import ru.otus.igorr.books.lesson10.dto.DtoConverter;
import ru.otus.igorr.books.lesson10.repository.author.AuthorRepository;
import ru.otus.igorr.books.lesson10.repository.book.BookRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class AuthorServiceImpl implements AuthorService {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final DtoConverter converter;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository,
                             BookRepository bookRepository,
                             @Qualifier("authorConverter") DtoConverter converter) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.converter = converter;
    }

    @Override
    public long add(AuthorDto dto) {
        return authorRepository.saveAndFlush(((AuthorDtoConverter) converter).fill(dto)).getId();
    }

    @Override
    public AuthorDto getById(long id) {
        return null;
    }

    @Override
    public List<AuthorDto> getByBook(BookDto book) {
        return null;
    }

    @Override
    public List<AuthorDto> getListWithoutBooks() {
        return converter.convertList(authorRepository.findAll());
    }

    @Override
    public List<AuthorDto> getListWithBooks() {
        List<Author> authorList = authorRepository.findAll();
        authorList.forEach(author -> {
            Set<Book> books = new HashSet<>();
            books.addAll(bookRepository.findByAuthorNative(author.getId()));
            author.setBooks(books);

        });
        return converter.convertList(authorList);
    }
}
