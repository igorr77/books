package ru.otus.igorr.books.lesson18.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.dto.GenreDto;
import ru.otus.igorr.books.lesson18.handlers.GenreHandler;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * ref https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux-client-testing
 * ref https://www.callicoder.com/spring-5-reactive-webclient-webtestclient-examples/
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class GenreControllerTest {


    @Autowired
    private GenreController controller;
    private GenreHandler handler;
    private RouterFunction<ServerResponse> route;
    private RouterFunction<ServerResponse> otherRoute;
    private WebTestClient client;


    @BeforeEach
    void startUp() {

        handler = new GenreHandler(controller);

        route = route()
                //.GET("/person/{id}", accept(APPLICATION_JSON), handler::find)
                .GET("/flux/genre", accept(APPLICATION_JSON), handler::listPage)
                .GET("/flux/genre/{id}", accept(APPLICATION_JSON), handler::viewPage)
                .POST("/flux/genre", handler::addPage)
                //.add(otherRoute)
                .build();

        client = WebTestClient
                .bindToRouterFunction(route)
                .build();
    }

    @Test
    void listPageFlux() {

        client.get()
                .uri("/flux/genre")
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    void viewPageFluxTest() {

        client.get()
                .uri("/flux/genre/1")
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    void addPageFluxTest() {
        GenreDto dto = new GenreDto();
        dto.setName("Genre.Name.Flux");
        dto.setDescription("Test reactive controller");
        client.post()
                .uri("/flux/genre")
                .body(Mono.just(dto), GenreDto.class)
                .exchange()
                .expectStatus()
                .isOk();

    }
}