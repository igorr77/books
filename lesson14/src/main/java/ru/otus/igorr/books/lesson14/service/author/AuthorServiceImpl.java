package ru.otus.igorr.books.lesson14.service.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson14.domain.author.Author;
import ru.otus.igorr.books.lesson14.dto.AuthorDto;
import ru.otus.igorr.books.lesson14.dto.DtoConverter;
import ru.otus.igorr.books.lesson14.execptions.DeleteReferenceRecordException;
import ru.otus.igorr.books.lesson14.repository.author.AuthorRepository;
import ru.otus.igorr.books.lesson14.repository.book.BookRepository;

import java.util.List;


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

    @Override
    public void delete(String id) {
        if (bookRepository.existsAuthor(id)) {
            throw new DeleteReferenceRecordException(id);
        }
        authorRepository.deleteById(id);
    }
}
