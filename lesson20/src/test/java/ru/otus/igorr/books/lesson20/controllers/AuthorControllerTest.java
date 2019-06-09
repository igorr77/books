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
import ru.otus.igorr.books.lesson20.dto.AuthorDto;
import ru.otus.igorr.books.lesson20.dto.GenreDto;
import ru.otus.igorr.books.lesson20.handlers.AuthorHandler;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AuthorControllerTest {

    @Autowired
    private AuthorController controller;
    private AuthorHandler handler;
    private RouterFunction<ServerResponse> route;
    private RouterFunction<ServerResponse> otherRoute;
    private WebTestClient client;



    @BeforeEach
    void startUp() {

        handler = new AuthorHandler(controller);

        route = route()
                .GET("/author", accept(APPLICATION_JSON), handler::listPage)
                .GET("/author/{id}", accept(APPLICATION_JSON), handler::viewPage)
                .POST("/author", handler::addPage)
                //.add(otherRoute)
                .build();

        client = WebTestClient
                .bindToRouterFunction(route)
                .build();
    }

    @Test
    void getAuthorListTest() {

        client.get()
                .uri("/author")
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    void getAuthorTest() {

        client.get()
                .uri("/author/1")
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    void addAuthorTest() {
        List<GenreDto> genres = new ArrayList<>();
        GenreDto genre = new GenreDto();
        genres.add(genre);
        genre.setId("1");

        AuthorDto dto = new AuthorDto();
        dto.setFirstName("Test.Firstname");
        dto.setSurName("Test.Surname");
        dto.setLastName("Test.Lastname");
        dto.setGenreList(genres);
        client.post()
                .uri("/author")
                .body(Mono.just(dto), AuthorDto.class)
                .exchange()
                .expectStatus()
                .isOk();

    }
}