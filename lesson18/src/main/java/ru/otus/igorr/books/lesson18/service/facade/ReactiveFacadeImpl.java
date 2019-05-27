package ru.otus.igorr.books.lesson18.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.dto.GenreDto;
import ru.otus.igorr.books.lesson18.service.genre.GenreReactiveService;


@Service
public class ReactiveFacadeImpl implements ReactiveFacade {

    private final GenreReactiveService genreService;

    @Autowired
    public ReactiveFacadeImpl(GenreReactiveService genreService) {
        this.genreService = genreService;
    }

    // Genre

    @Override
    public Flux<GenreDto> getGenreList() {
        return genreService.list();
    }

    @Override
    public Mono<GenreDto> getGenre(String id) {
        return genreService.get(id);
    }

    @Override
    public Mono<GenreDto> addGenre(GenreDto genre) {
        return genreService.add(genre);
    }


}
