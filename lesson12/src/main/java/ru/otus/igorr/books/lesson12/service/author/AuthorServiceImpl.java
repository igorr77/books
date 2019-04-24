package ru.otus.igorr.books.lesson12.service.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson12.domain.author.Author;
import ru.otus.igorr.books.lesson12.domain.book.Book;
import ru.otus.igorr.books.lesson12.dto.AuthorDto;
import ru.otus.igorr.books.lesson12.dto.AuthorDtoConverter;
import ru.otus.igorr.books.lesson12.dto.BookDto;
import ru.otus.igorr.books.lesson12.dto.DtoConverter;
import ru.otus.igorr.books.lesson12.repository.author.AuthorRepository;
import ru.otus.igorr.books.lesson12.repository.book.BookRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class AuthorServiceImpl implements AuthorService {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final DtoConverter<Author, AuthorDto> converter;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository,
                             BookRepository bookRepository,
                             @Qualifier("authorConverter") DtoConverter converter) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.converter = converter;
    }

    @Override
    public AuthorDto getById(String id) {
        return converter.convert(authorRepository.findById(id).orElse(Author.empty()));
    }

    @Override
    public String add(AuthorDto dto) {
        return authorRepository.save(converter.fill(dto)).getId();
    }

    @Override
    public List<AuthorDto> getListAll() {
        return converter.convertList(authorRepository.findAll());
    }

    @Override
    public List<AuthorDto> getListByName(String mask) {
        List<Author> genreList = authorRepository.findByNameLike(mask);
        return converter.convertList(genreList);
    }
}
