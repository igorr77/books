package ru.otus.igorr.books.lesson18.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.dto.BookDto;
import ru.otus.igorr.books.lesson18.service.facade.ServicesFacade;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final ServicesFacade services;

    @GetMapping("/book")
    Flux<BookDto> getBookList() {
        return services.getBookList();
    }

    @GetMapping("/book/{id}")
    Mono<BookDto> getBook(@PathVariable String id) {
        return services.getBook(id);
    }

    @PostMapping("/book")
    Mono<BookDto> addBook(@RequestBody BookDto book) {
        return services.addBook(book);
    }

    @DeleteMapping("/book/{id}")
    Mono<Void> deleteBook(@PathVariable String id) {
        return services.deleteBook(id);
    }


}
