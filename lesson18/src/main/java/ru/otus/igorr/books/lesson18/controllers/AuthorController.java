package ru.otus.igorr.books.lesson18.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.dto.AuthorDto;
import ru.otus.igorr.books.lesson18.service.facade.RServicesFacade;
import ru.otus.igorr.books.lesson18.service.facade.ServicesFacade;

@RestController
public class AuthorController {


    private final ServicesFacade services;
    private final RServicesFacade rServices;

    @Autowired
    public AuthorController(ServicesFacade services, RServicesFacade rServices) {
        this.services = services;
        this.rServices = rServices;
    }

//    @CrossOrigin
//    @GetMapping("/author")
//    public List<AuthorDto> listPage() {
//        return services.getAuthorList();
//    }
//
//    @CrossOrigin
//    @GetMapping("/author/{id}")
//    public AuthorDto viewPage(@PathVariable String id){
//        return services.getAuthor(id);
//    }
//
//
//    @CrossOrigin
//    @PostMapping("/author")
//    public ResponseId addPage(@RequestBody AuthorDto author) {
//        return new ResponseId(services.addAuthor(author));
//    }

    // flux
    @GetMapping(value = "/flux/author", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<AuthorDto> listPageFlux() {
        return rServices.getAuthorList();
    }

    @GetMapping(value = "/flux/author/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<AuthorDto> viewPageFlux(@PathVariable String id){
        return rServices.getAuthor(id);
    }

    @PostMapping(value = "/flux/author", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<AuthorDto> addPageFlux(@RequestBody AuthorDto author) {
        return rServices.addAuthor(author);
    }

}
