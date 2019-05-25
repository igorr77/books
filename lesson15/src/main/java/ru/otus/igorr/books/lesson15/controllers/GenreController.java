package ru.otus.igorr.books.lesson15.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.igorr.books.lesson15.dto.GenreDto;
import ru.otus.igorr.books.lesson15.service.facade.ServicesFacade;

import java.util.List;

@RestController
public class GenreController {

    private final ServicesFacade services;

    @Autowired
    public GenreController(ServicesFacade services) {
        this.services = services;
    }

    //@CrossOrigin
    @GetMapping("/genre/list")
    List<GenreDto> listPage() {
        return services.getGenreList();  }

    //@CrossOrigin
    @GetMapping("/genre/{id}")
    GenreDto viewPage(@PathVariable String id){
        return services.getGenre(id);
    }

    //@CrossOrigin
    @PostMapping("/genre/add")
    ResponseId addPage(@RequestBody GenreDto genre){
        return new ResponseId(services.addGenre(genre));
    }

}
