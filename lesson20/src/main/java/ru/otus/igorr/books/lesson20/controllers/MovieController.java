package ru.otus.igorr.books.lesson20.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import ru.otus.igorr.books.lesson20.repository.movie.MovieRepository;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping("/movie/list")
    public String pageList(final Model model) {

        // loads 1 and display 1, stream data, data driven mode.
        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(movieRepository.findAll(), 1);

        model.addAttribute("movies", reactiveDataDrivenMode);

        return "movie/list";
    }

}
