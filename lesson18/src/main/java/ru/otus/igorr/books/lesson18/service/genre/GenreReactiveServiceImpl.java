package ru.otus.igorr.books.lesson18.service.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.domain.genre.Genre;
import ru.otus.igorr.books.lesson18.dto.DtoConverter;
import ru.otus.igorr.books.lesson18.dto.GenreDto;
import ru.otus.igorr.books.lesson18.repository.genre.GenreReactiveRepository;

@Service
public class GenreReactiveServiceImpl implements GenreReactiveService {


    private final GenreReactiveRepository genreRepository;
    private final DtoConverter<Genre, GenreDto> converter;

    @Autowired
    public GenreReactiveServiceImpl(GenreReactiveRepository genreRepository,
                                    @Qualifier("genreConverter") DtoConverter converter) {
        this.genreRepository = genreRepository;
        this.converter = converter;
    }

    @Override
    public Flux<GenreDto> list() {
        return genreRepository.findAll()
                .map(genre -> converter.convert(genre));
    }

    @Override
    public Mono<GenreDto> get(String id) {
        return genreRepository.findById(id)
                .map(genre -> converter.convert(genre));
    }

    @Override
    public Mono<GenreDto> add(GenreDto genreDto) {
        return genreRepository.save(converter.fill(genreDto))
                .map(genre -> converter.convert(genre));
    }


}
