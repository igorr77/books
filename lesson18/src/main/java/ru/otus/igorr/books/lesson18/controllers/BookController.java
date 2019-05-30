package ru.otus.igorr.books.lesson18.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.igorr.books.lesson18.dto.BookDto;
import ru.otus.igorr.books.lesson18.service.facade.ServicesFacade;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final ServicesFacade services;

    // TODO: 30.05.2019 Убрать @CrossOrigin

    @CrossOrigin
    @GetMapping("/book")
    List<BookDto> listPage() {
        return services.getBookList();
    }

    @CrossOrigin
    @GetMapping("/book/{id}")
    BookDto viewPage(@PathVariable String id) {
        return services.getBook(id);
    }

    @CrossOrigin
    @PostMapping("/book")
    ResponseId addPage(@RequestBody BookDto book) {
        return new ResponseId(services.addBook(book));
    }



}
