package ru.otus.igorr.books.lesson18.handlers;


import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.controllers.GenreController;
import ru.otus.igorr.books.lesson18.dto.GenreDto;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


public class GenreHandler {

    private final GenreController controller;

    public GenreHandler(GenreController controller) {
        this.controller = controller;
    }

    public Mono<ServerResponse> listPage(ServerRequest request) {
        Flux<GenreDto> flux = controller.listPageFlux();
        return ok().contentType(APPLICATION_JSON).body(flux, GenreDto.class);
    }

    public Mono<ServerResponse> viewPage(ServerRequest request) {
        Mono<GenreDto> mono = controller.viewPageFlux(request.pathVariable("id"));
        return ok().contentType(APPLICATION_JSON).body(mono, GenreDto.class);
    }

    public Mono<ServerResponse> addPage(ServerRequest request) {
        Mono<GenreDto> mono = controller.addPageFlux(request.bodyToMono(GenreDto.class).block());
        return ok().contentType(APPLICATION_JSON).body(mono, GenreDto.class);
    }


}
