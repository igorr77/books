package ru.otus.igorr.books.lesson14.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.igorr.books.lesson14.dto.AuthorDto;
import ru.otus.igorr.books.lesson14.dto.BookDto;
import ru.otus.igorr.books.lesson14.dto.GenreDto;
import ru.otus.igorr.books.lesson14.service.author.AuthorService;
import ru.otus.igorr.books.lesson14.service.book.BookService;
import ru.otus.igorr.books.lesson14.service.genre.GenreService;

import java.util.Arrays;
import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService, GenreService genreService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
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


    @GetMapping("/book/add")
    String addPage(Model model) {
        model.addAttribute("authors", authorService.getListAll());
        model.addAttribute("genres", genreService.getList());
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
                .authorList(Arrays.asList(authorService.getById(author)))
                .genre(genreService.getById(genre))
                .description(description)
                .build();

        bookService.add(book);

        model.addAttribute("books", getBookList());
        return "author/list";
    }

    @GetMapping("/book/edit")
    String viewPage(Model model){
        model.addAttribute("readOnly", true);
        return "book/edit";
    }

    private List<BookDto> getBookList() {
        return bookService.getList();
    }


}
