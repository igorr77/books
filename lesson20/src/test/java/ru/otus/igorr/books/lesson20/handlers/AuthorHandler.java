package ru.otus.igorr.books.lesson20.handlers;


import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson20.controllers.AuthorController;
import ru.otus.igorr.books.lesson20.dto.AuthorDto;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


public class AuthorHandler {

    private final AuthorController controller;

    public AuthorHandler(AuthorController controller) {
        this.controller = controller;
    }

    public Mono<ServerResponse> listPage(ServerRequest request) {
        Flux<AuthorDto> flux = controller.getAuthorList();
        return ok().contentType(APPLICATION_JSON).body(flux, AuthorDto.class);
    }

    public Mono<ServerResponse> viewPage(ServerRequest request) {
        Mono<AuthorDto> mono = controller.getAuthor(request.pathVariable("id"));
        return ok().contentType(APPLICATION_JSON).body(mono, AuthorDto.class);
    }

    public Mono<ServerResponse> addPage(ServerRequest request) {
        Mono<AuthorDto> mono = controller.addAuthor(request.bodyToMono(AuthorDto.class).block());
        return ok().contentType(APPLICATION_JSON).body(mono, AuthorDto.class);
    }


}
