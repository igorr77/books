package ru.otus.igorr.books.lesson18.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.igorr.books.lesson18.dto.BookDto;
import ru.otus.igorr.books.lesson18.service.facade.ServicesFacade;

import java.util.List;

@RestController
public class BookController {

    private final ServicesFacade services;

    @Autowired
    public BookController(ServicesFacade services) {
        this.services = services;
    }

    @CrossOrigin
    @GetMapping("/book/list")
    List<BookDto> listPage() {
        return services.getBookList();
    }

    @CrossOrigin
    @GetMapping("/book/{id}")
    BookDto viewPage(@PathVariable String id) {
        return services.getBook(id);
    }



    @CrossOrigin
    @PostMapping("/book/add")
    ResponseId addPage(@RequestBody BookDto book) {
        return new ResponseId(services.addBook(book));
    }



}
