package ru.otus.igorr.books.lesson18.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.dto.GenreDto;
import ru.otus.igorr.books.lesson18.service.facade.ReactiveFacade;
import ru.otus.igorr.books.lesson18.service.facade.ServicesFacade;

import java.util.List;

@RestController
public class GenreController {

    private final ServicesFacade services;
    private final ReactiveFacade rServices;

    @Autowired
    public GenreController(ServicesFacade services,
                           ReactiveFacade rServices) {
        this.services = services;
        this.rServices = rServices;
    }


    @CrossOrigin
    @GetMapping("/genre/list")
    List<GenreDto> listPage() {
        return services.getGenreList();
    }

    @CrossOrigin
    @GetMapping("/genre/{id}")
    GenreDto viewPage(@PathVariable String id) {
        return services.getGenre(id);
    }

    @CrossOrigin
    @PostMapping("/genre/add")
    ResponseId addPage(@RequestBody GenreDto genre) {
        return new ResponseId(services.addGenre(genre));
    }

    // Reactive
    @GetMapping("/flux/genre")
    Flux<GenreDto> fluxListPage() {
        return rServices.getGenreList();
    }

    @GetMapping("/flux/genre/{id}")
    Mono<GenreDto> fluxViewPage(@PathVariable String id) {
        return rServices.getGenre(id);
    }

    @PostMapping("/flux/genre/add")
    Mono<GenreDto> fluxAddPage(@RequestBody GenreDto genre) {
        return rServices.addGenre(genre);
    }


}
