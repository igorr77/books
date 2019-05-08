package ru.otus.igorr.books.lesson14.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.igorr.books.lesson14.dto.GenreDto;
import ru.otus.igorr.books.lesson14.service.genre.GenreService;

import java.util.List;

@Controller
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genre/list")
    String listPage(Model model) {

        model.addAttribute("genres", getGenreList());
        return "genre/list";
    }

    @GetMapping("/genre/add")
    String addPage(){
        return "genre/add";
    }

    @PostMapping("/genre/add")
    String addPage(@RequestParam String name, @RequestParam String description, Model model){


        genreService.add(new GenreDto(name, description));

        model.addAttribute("genres", getGenreList());
        return "genre/list";
    }

    private List<GenreDto> getGenreList(){
        return genreService.getList();
    }

}
