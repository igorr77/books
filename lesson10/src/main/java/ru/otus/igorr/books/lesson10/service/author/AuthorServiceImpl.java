package ru.otus.igorr.books.lesson10.service.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson10.domain.author.Author;
import ru.otus.igorr.books.lesson10.dto.AuthorDto;
import ru.otus.igorr.books.lesson10.dto.AuthorDtoConverter;
import ru.otus.igorr.books.lesson10.dto.BookDto;
import ru.otus.igorr.books.lesson10.dto.DtoConverter;
import ru.otus.igorr.books.lesson10.repository.author.AuthorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class AuthorServiceImpl implements AuthorService {


    private final AuthorRepository authorRepository;
    private final DtoConverter converter;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository,
                             @Qualifier("authorConverter") DtoConverter converter) {
        this.authorRepository = authorRepository;
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
    public List<AuthorDto> getList() {
        List<AuthorDto> authorList = new ArrayList<>();

        List<Author> authors = authorRepository.findAll();

        return authorList;

    }
}
