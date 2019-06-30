package ru.otus.igorr.books.lesson23.service.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson23.domain.mongo.author.Author;
import ru.otus.igorr.books.lesson23.dto.AuthorDto;
import ru.otus.igorr.books.lesson23.dto.DtoConverter;
import ru.otus.igorr.books.lesson23.execptions.DeleteReferenceRecordException;
import ru.otus.igorr.books.lesson23.execptions.IncorrectDataException;
import ru.otus.igorr.books.lesson23.repository.mongo.author.AuthorRepository;
import ru.otus.igorr.books.lesson23.repository.mongo.book.BookRepository;

import java.util.List;
import java.util.stream.Collectors;


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
    public AuthorDto get(String id) {
        return converter.convert(authorRepository.findById(id).orElse(Author.empty()));
    }

    @Override
    public String add(AuthorDto dto) {

        if(dto.getGenreList().stream()
                .filter(genreDto -> genreDto.getId() == null)
                .count() != 0) {
            throw new IncorrectDataException();
        }

        return authorRepository.save(converter.fill(dto)).getId();
    }

    @Override
    public List<AuthorDto> getList() {
        return authorRepository.findAll()
                .stream()
                .map(author -> converter.convert(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorDto> getListByName(String mask) {
        return authorRepository.findByNameLike(mask)
                .stream()
                .map(author -> converter.convert(author))
                .collect(Collectors.toList());

    }

    @Override
    public void delete(String id) {
        if (bookRepository.existsAuthor(id)) {
            throw new DeleteReferenceRecordException(id);
        }
        authorRepository.deleteById(id);
    }
}
