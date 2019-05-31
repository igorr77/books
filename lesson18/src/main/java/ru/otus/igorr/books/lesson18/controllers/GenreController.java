package ru.otus.igorr.books.lesson18.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.dto.GenreDto;
import ru.otus.igorr.books.lesson18.service.facade.RServicesFacade;
import ru.otus.igorr.books.lesson18.service.facade.ServicesFacade;

@RestController
public class GenreController {

    private final ServicesFacade services;
    private final RServicesFacade rServices;

    @Autowired
    public GenreController(ServicesFacade services,
                           RServicesFacade rServices) {
        this.services = services;
        this.rServices = rServices;
    }


    // TODO: 30.05.2019 Решить вопрос с @CrossOrigin

//    @CrossOrigin
//    @GetMapping("/genre")
//    List<GenreDto> listPage() {
//        return services.getGenreList();
//    }
//
//    @CrossOrigin
//    @GetMapping("/genre/{id}")
//    GenreDto viewPage(@PathVariable String id) {
//        return services.getGenre(id);
//    }
//
//    @CrossOrigin
//    @PostMapping("/genre")
//    ResponseId addPage(@RequestBody GenreDto genre) {
//        return new ResponseId(services.addGenre(genre));
//    }

    // Reactive
    @GetMapping(value = "/flux/genre", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<GenreDto> listPageFlux() {
        return rServices.getGenreList();
    }

    @GetMapping("/flux/genre/{id}")
    public Mono<GenreDto> viewPageFlux(@PathVariable String id) {
        return rServices.getGenre(id);
    }

    @PostMapping(value = "/flux/genre", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<GenreDto> addPageFlux(@RequestBody GenreDto genre) {
        return rServices.addGenre(genre);
    }


}
