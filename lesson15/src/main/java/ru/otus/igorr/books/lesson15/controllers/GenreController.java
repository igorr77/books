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

    @CrossOrigin
    @GetMapping("/genre/list")
    List<GenreDto> listPage() {
        return getGenreList();
    }

    @GetMapping("/genre/add")
    String addPage(){
        return "genre/add";
    }

    @CrossOrigin
    @PostMapping("/genre/add")
    String addPage(@RequestBody GenreDto genre){
        return services.addGenre(genre);
    }

    private List<GenreDto> getGenreList(){
        return services.getGenreList();
    }

}
