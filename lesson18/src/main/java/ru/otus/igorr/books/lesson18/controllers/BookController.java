package ru.otus.igorr.books.lesson18.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.igorr.books.lesson18.dto.BookDto;
import ru.otus.igorr.books.lesson18.service.facade.RServicesFacade;
import ru.otus.igorr.books.lesson18.service.facade.ServicesFacade;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final ServicesFacade services;
    private final RServicesFacade rServices;

    // TODO: 30.05.2019 Убрать @CrossOrigin

//    @CrossOrigin
//    @GetMapping("/book")
//    List<BookDto> listPage() {
//        return services.getBookList();
//    }
//
//    @CrossOrigin
//    @GetMapping("/book/{id}")
//    BookDto viewPage(@PathVariable String id) {
//        return services.getBook(id);
//    }
//
//    @CrossOrigin
//    @PostMapping("/book")
//    ResponseId addPage(@RequestBody BookDto book) {
//        return new ResponseId(services.addBook(book));
//    }

    @GetMapping("/book")
    Flux<BookDto> listPage() {
        return rServices.getBookList();
    }

    @GetMapping("/book/{id}")
    Mono<BookDto> viewPage(@PathVariable String id) {
        return rServices.getBook(id);
    }

    @PostMapping("/book")
    Mono<BookDto> addPage(@RequestBody BookDto book) {
        return rServices.addBook(book);
    }

    @DeleteMapping("/book/{id}")
    Mono<Void> deletePage(@PathVariable String id) {
        return rServices.deleteBook(id);
    }


}
