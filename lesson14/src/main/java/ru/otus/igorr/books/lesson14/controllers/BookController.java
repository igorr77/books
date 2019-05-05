package ru.otus.igorr.books.lesson14.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.igorr.books.lesson14.dto.BookDto;
import ru.otus.igorr.books.lesson14.service.author.AuthorService;
import ru.otus.igorr.books.lesson14.service.book.BookService;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/book/list")
    String listPage(Model model) {

        List<BookDto> books = bookService.getList();

        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/book/authors")
    String authorPage(@RequestParam String id, Model model) {


        BookDto book = bookService.get(id);

        model.addAttribute("book", book);
        return "book/authors";
    }


}
