package ru.otus.igorr.books.lesson23.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.igorr.books.lesson23.dto.GenreDto;
import ru.otus.igorr.books.lesson23.service.facade.ServicesFacade;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GenreController {

    private final ServicesFacade services;

    @GetMapping("/genre/list")
    String listPage(Model model) {

        model.addAttribute("genres", getGenreList());
        return "genre/list";
    }


    @GetMapping("/genre/add")
    String addPage() {
        return "genre/add";
    }

    @PostMapping("/genre/add")
    String addPage(@RequestParam String name, @RequestParam String description, Model model) {


        services.addGenre(new GenreDto(name, description));

        model.addAttribute("genres", getGenreList());
        return "genre/list";
    }

    // TODO: 23.06.2019 Реализовать полный реактивный стек 
    private List<GenreDto> getGenreList() {
        return services.getGenreList();
    }

}
