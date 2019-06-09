package ru.otus.igorr.books.lesson20.controllers;

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
import ru.otus.igorr.books.lesson20.dto.GenreDto;
import ru.otus.igorr.books.lesson20.handlers.GenreHandler;

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
                .GET("/genre", accept(APPLICATION_JSON), handler::listPage)
                .GET("/genre/{id}", accept(APPLICATION_JSON), handler::viewPage)
                .POST("/genre", handler::addPage)
                //.add(otherRoute)
                .build();

        client = WebTestClient
                .bindToRouterFunction(route)
                .build();
    }

    @Test
    void getGenreListTest() {

        client.get()
                .uri("/genre")
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    void getGenreTest() {

        client.get()
                .uri("/genre/1")
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    void addGenreTest() {
        GenreDto dto = new GenreDto();
        dto.setName("Genre.Name.Flux");
        dto.setDescription("Test reactive controller");
        client.post()
                .uri("/genre")
                .body(Mono.just(dto), GenreDto.class)
                .exchange()
                .expectStatus()
                .isOk();

    }
}