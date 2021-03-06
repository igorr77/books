package ru.otus.igorr.books.lesson14.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.igorr.books.lesson14.dto.BookDto;
import ru.otus.igorr.books.lesson14.service.author.AuthorService;
import ru.otus.igorr.books.lesson14.service.book.BookService;
import ru.otus.igorr.books.lesson14.service.facade.ServicesFacade;
import ru.otus.igorr.books.lesson14.service.genre.GenreService;

import java.util.Arrays;
import java.util.List;

@Controller
public class BookController {

    private final ServicesFacade services;

    @Autowired
    public BookController(ServicesFacade services) {
        this.services = services;
    }

    @GetMapping("/book/list")
    String listPage(Model model) {

        List<BookDto> books = services.getBookList();

        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/book/authors")
    String authorPage(@RequestParam String id, Model model) {


        BookDto book = services.getBook(id);

        model.addAttribute("book", book);
        return "book/authors";
    }


    @GetMapping("/book/add")
    String addPage(Model model) {
        model.addAttribute("authors", services.getAuthorList());
        model.addAttribute("genres", services.getGenreList());
        return "book/add";
    }

    @PostMapping("/book/add")
    String addPage(@RequestParam String title,
                   @RequestParam String author,
                   @RequestParam String genre,
                   @RequestParam String description,
                   Model model) {

        BookDto book = new BookDto
                .Builder()
                .title(title)
                .authorList(Arrays.asList(services.getAuthor(author)))
                .genre(services.getGenre(genre))
                .description(description)
                .build();

        services.addBook(book);

        model.addAttribute("books", getBookList());
        return "book/list";
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
