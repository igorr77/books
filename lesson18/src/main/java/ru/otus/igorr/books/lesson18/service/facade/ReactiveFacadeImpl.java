package ru.otus.igorr.books.lesson18.service.facade;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import ru.otus.igorr.books.lesson18.dto.GenreDto;
import ru.otus.igorr.books.lesson18.service.genre.GenreReactiveService;


@Service
public class ReactiveFacadeImpl implements ReactiveFacade {

    private final GenreReactiveService genreService;

    public ReactiveFacadeImpl(GenreReactiveService genreService) {
        this.genreService = genreService;
    }

    @Override
    public Flux<GenreDto> findAll() {
        return genreService.findAll();
    }
}
