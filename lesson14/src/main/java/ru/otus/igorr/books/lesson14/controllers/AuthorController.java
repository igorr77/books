package ru.otus.igorr.books.lesson14.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.igorr.books.lesson14.dto.AuthorDto;
import ru.otus.igorr.books.lesson14.service.author.AuthorService;
import ru.otus.igorr.books.lesson14.service.facade.ServicesFacade;
import ru.otus.igorr.books.lesson14.service.genre.GenreService;

import java.util.Arrays;
import java.util.List;

@Controller
public class AuthorController {


    private final ServicesFacade services;

    @Autowired
    public AuthorController(ServicesFacade services) {
        this.services = services;
    }

    @GetMapping("/author/list")
    String listPage(Model model) {

        model.addAttribute("authors", getAuthorList());
        return "author/list";
    }

    @GetMapping("/author/add")
    String addPage(Model model) {
        model.addAttribute("genres", services.getGenreList());
        return "author/add";
    }

    @PostMapping("/author/add")
    String addPage(@RequestParam String lastname,
                   @RequestParam String firstname,
                   @RequestParam String surname,
                   @RequestParam String genre,
                   Model model) {


        AuthorDto author = new AuthorDto(null, firstname, lastname, surname, Arrays.asList(services.getGenre(genre)), null);
        services.addAuthor(author);

        model.addAttribute("authors", getAuthorList());
        return "author/list";
    }

    private List<AuthorDto> getAuthorList() {
        return services.getAuthorList();
    }

}
