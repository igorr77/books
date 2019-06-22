package ru.otus.igorr.books.lesson20.controllers;


import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.igorr.books.lesson20.dto.AuthorDto;
import ru.otus.igorr.books.lesson20.dto.GenreDto;
import ru.otus.igorr.books.lesson20.service.facade.ServicesFacade;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorController {


    private final ServicesFacade services;


    @GetMapping("/author/list")
    String listPage(Model model) {

        model.addAttribute("authors", getAuthorList());
        return "author/list";
    }


    @GetMapping("/author/{id}")
    String pageView(@RequestParam String id, Model model){
        return "author/list";
    }

    @GetMapping("/author/add")
    String addPage(Model model) {
        model.addAttribute("genres", getGenreList());
        return "author/add";
    }

    @PostMapping("/author/add")
    String addPage(@RequestParam String lastname,
                   @RequestParam String firstname,
                   @RequestParam String surname,
                   @RequestParam String genre,
                   Model model) {

        val genres = new ArrayList<GenreDto>();

        services.getGenre(genre).map(g -> genres.add(g));

        AuthorDto author = new AuthorDto(null,
                firstname,
                lastname,
                surname,
                genres,
                null);

        AuthorDto newAuthor = services.addAuthor(author).block();

        model.addAttribute("authors", getAuthorList());
        return "author/list";
    }

    private List<AuthorDto> getAuthorList() {
        return services.getAuthorList().collectList().block();
    }

    private List<GenreDto> getGenreList() {
        return services.getGenreList().collectList().block();
    }


}
