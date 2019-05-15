package ru.otus.igorr.books.lesson15.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.igorr.books.lesson15.dto.BookDto;
import ru.otus.igorr.books.lesson15.service.facade.ServicesFacade;

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
    @GetMapping("/book/authors")
    BookDto authorPage(@RequestParam String id) {
        return services.getBook(id);
    }


    @GetMapping("/book/add")
    String addPage(Model model) {
        model.addAttribute("authors", services.getAuthorList());
        model.addAttribute("genres", services.getGenreList());
        return "book/add";
    }

    @PostMapping("/book/add")
    String addPage(@RequestBody BookDto book) {
        return services.addBook(book);
    }

    @GetMapping("/book/view")
    String viewPage(@RequestParam String id, Model model) {

        model.addAttribute("book", services.getBook(id));

        model.addAttribute("readOnly", true);
        return "book/edit";
    }

    @PostMapping("/book/edit")
    String editPage(@RequestParam String id, Model model) {

        model.addAttribute("book", services.getBook(id));

        model.addAttribute("readOnly", false);
        return "book/edit";
    }

    @PostMapping("/book/save")
    String savePage(@RequestParam String id, Model model) {

        model.addAttribute("book", services.getBook(id));

        model.addAttribute("readOnly", true);
        return "book/edit";
    }

    private List<BookDto> getBookList() {
        return services.getBookList();
    }


}
