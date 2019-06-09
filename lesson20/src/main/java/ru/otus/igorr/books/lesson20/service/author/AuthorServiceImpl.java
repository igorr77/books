package ru.otus.igorr.books.lesson20.service.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson20.domain.author.Author;
import ru.otus.igorr.books.lesson20.dto.AuthorDto;
import ru.otus.igorr.books.lesson20.dto.DtoConverter;
import ru.otus.igorr.books.lesson20.repository.author.AuthorReactiveRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorReactiveRepository repository;
    private final DtoConverter<Author, AuthorDto> converter;

    @Autowired
    public AuthorServiceImpl(AuthorReactiveRepository repository,
                             DtoConverter<Author, AuthorDto> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public Mono<AuthorDto> get(String id) {
        return repository.findById(id).map(author -> converter.convert(author));
    }

    @Override
    public Mono<AuthorDto> add(AuthorDto dto) {
        return repository.save(converter.fill(dto))
                .map(author -> converter.convert(author));
    }

    @Override
    public Flux<AuthorDto> getList() {
        return repository.findAll()
                .map(author -> converter.convert(author));
    }

    @Override
    public Flux<AuthorDto> getListByName(String mask) {
        // TODO: 31.05.2019
        return null;
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
