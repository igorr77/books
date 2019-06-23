package ru.otus.igorr.books.lesson22.service.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson22.domain.genre.Genre;
import ru.otus.igorr.books.lesson22.dto.DtoConverter;
import ru.otus.igorr.books.lesson22.dto.GenreDto;
import ru.otus.igorr.books.lesson22.repository.genre.GenreReactiveRepository;

@Service
public class GenreServiceImpl implements GenreService {


    private final GenreReactiveRepository genreRepository;
    private final DtoConverter<Genre, GenreDto> converter;

    @Autowired
    public GenreServiceImpl(GenreReactiveRepository genreRepository,
                            DtoConverter<Genre, GenreDto> converter) {
        this.genreRepository = genreRepository;
        this.converter = converter;
    }

    @Override
    public Flux<GenreDto> list() {
        return genreRepository.findAll()
                .map(genre -> converter.convert(genre));
    }

    @Override
    public Flux<GenreDto> getListByName(String mask) {
        // TODO: 29.05.2019
        return null;
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

    @Override
    public Mono<Void> delete(String id) {
        return genreRepository.deleteById(id);
    }

    @Override
    public Mono<Void> delete(GenreDto genreDto) {
        return genreRepository.delete(converter.fill(genreDto));
    }


}
