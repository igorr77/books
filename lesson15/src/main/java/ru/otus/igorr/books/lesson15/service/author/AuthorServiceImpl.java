package ru.otus.igorr.books.lesson15.service.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson15.domain.author.Author;
import ru.otus.igorr.books.lesson15.dto.AuthorDto;
import ru.otus.igorr.books.lesson15.dto.DtoConverter;
import ru.otus.igorr.books.lesson15.execptions.DeleteReferenceRecordException;
import ru.otus.igorr.books.lesson15.execptions.IncorrectDataException;
import ru.otus.igorr.books.lesson15.repository.author.AuthorRepository;
import ru.otus.igorr.books.lesson15.repository.book.BookRepository;

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
