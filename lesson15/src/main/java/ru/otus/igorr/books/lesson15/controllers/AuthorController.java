package ru.otus.igorr.books.lesson15.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.igorr.books.lesson15.dto.AuthorDto;
import ru.otus.igorr.books.lesson15.service.facade.ServicesFacade;

import java.util.List;

@RestController
public class AuthorController {


    private final ServicesFacade services;

    @Autowired
    public AuthorController(ServicesFacade services) {
        this.services = services;
    }

    @CrossOrigin
    @GetMapping("/author/list")
    List<AuthorDto> listPage() {
        return services.getAuthorList();
    }

    @CrossOrigin
    @GetMapping("/author/{id}")
    AuthorDto viewPage(@PathVariable String id){
        return services.getAuthor(id);
    }


    @CrossOrigin
    @PostMapping("/author/add")
    ResponseId addPage(@RequestBody AuthorDto author) {
        return new ResponseId(services.addAuthor(author));
    }

}
