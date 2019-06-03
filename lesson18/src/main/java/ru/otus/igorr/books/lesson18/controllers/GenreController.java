package ru.otus.igorr.books.lesson18.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.dto.GenreDto;
import ru.otus.igorr.books.lesson18.service.facade.ServicesFacade;

@RestController
@RequiredArgsConstructor
public class GenreController {

    private final ServicesFacade services;

    @GetMapping("/genre")
    public Flux<GenreDto> listPageFlux() {
        return services.getGenreList();
    }

    @GetMapping("/genre/{id}")
    public Mono<GenreDto> viewPageFlux(@PathVariable String id) {
        return services.getGenre(id);
    }

    @PostMapping("/genre")
    public Mono<GenreDto> addPageFlux(@RequestBody GenreDto genre) {
        return services.addGenre(genre);
    }

    @DeleteMapping("/genre/{id}")
    public Mono<Void> deletePageFlux(@PathVariable String id) {
        return services.deleteGenre(id);
    }


}
