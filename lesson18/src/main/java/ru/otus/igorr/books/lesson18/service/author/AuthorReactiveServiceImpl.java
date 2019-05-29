package ru.otus.igorr.books.lesson18.service.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.dto.AuthorDto;
import ru.otus.igorr.books.lesson18.repository.author.AuthorReactiveRepository;

@Service
public class AuthorReactiveServiceImpl implements AuthorReactiveService {

    private final AuthorReactiveRepository authorRepository;

    @Autowired
    public AuthorReactiveServiceImpl(AuthorReactiveRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Mono<AuthorDto> get(String id) {
        return null;
    }

    @Override
    public Mono<AuthorDto> add(AuthorDto dto) {
        return null;
    }

    @Override
    public Flux<AuthorDto> getList() {
        return null;
    }

    @Override
    public Flux<AuthorDto> getListByName(String mask) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
