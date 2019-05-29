package ru.otus.igorr.books.lesson18.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.dto.AuthorDto;
import ru.otus.igorr.books.lesson18.service.facade.ReactiveFacade;
import ru.otus.igorr.books.lesson18.service.facade.ServicesFacade;

import java.util.List;

@RestController
public class AuthorController {


    private final ServicesFacade services;
    private final ReactiveFacade rServices;

    @Autowired
    public AuthorController(ServicesFacade services, ReactiveFacade rServices) {
        this.services = services;
        this.rServices = rServices;
    }

    @CrossOrigin
    @GetMapping("/author/list")
    List<AuthorDto> listPage() {
        return services.getAuthorList();
    }

    @CrossOrigin
    @GetMapping("/author/{id}")
    AuthorDto viewPage(@PathVariable String id){
        return services.getAuthor(id);
    }


    @CrossOrigin
    @PostMapping("/author/add")
    ResponseId addPage(@RequestBody AuthorDto author) {
        return new ResponseId(services.addAuthor(author));
    }

    // flux
    @GetMapping("/flux/author")
    Flux<AuthorDto> listPageFlux() {
        return rServices.getAuthorList();
    }

    @GetMapping("/author/{id}")
    Mono<AuthorDto> viewPageFlux(@PathVariable String id){
        return rServices.getAuthor(id);
    }


    @PostMapping("/author/add")
    Mono<AuthorDto> addPageFlux(@RequestBody AuthorDto author) {
        return rServices.addAuthor(author);
    }


}
