package ru.otus.igorr.books.lesson18.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.dto.AuthorDto;
import ru.otus.igorr.books.lesson18.service.facade.ServicesFacade;

@RestController
@RequiredArgsConstructor
public class AuthorController {


    private final ServicesFacade services;

    @GetMapping("/author")
    public Flux<AuthorDto> listPageFlux() {
        return services.getAuthorList();
    }

    @GetMapping("/author/{id}")
    public Mono<AuthorDto> viewPageFlux(@PathVariable String id) {
        return services.getAuthor(id);
    }

    @PostMapping("/author")
    public Mono<AuthorDto> addPageFlux(@RequestBody AuthorDto author) {
        return services.addAuthor(author);
    }

    @DeleteMapping("/author/{id}")
    public Mono<Void> deletePage(@PathVariable String id) {
        return services.deleteAuthor(id);
    }

}
