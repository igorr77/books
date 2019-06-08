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
    public Flux<GenreDto> getGenreList() {
        return services.getGenreList();
    }

    @GetMapping("/genre/{id}")
    public Mono<GenreDto> getGenre(@PathVariable String id) {
        return services.getGenre(id);
    }

    @PostMapping("/genre")
    public Mono<GenreDto> addGenre(@RequestBody GenreDto genre) {
        return services.addGenre(genre);
    }

    @DeleteMapping("/genre/{id}")
    public Mono<Void> deleteGenre(@PathVariable String id) {
        return services.deleteGenre(id);
    }


}
