package ru.otus.igorr.books.lesson25.controllers;


import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.igorr.books.lesson25.dto.AuthorDto;
import ru.otus.igorr.books.lesson25.dto.BookDto;
import ru.otus.igorr.books.lesson25.dto.GenreDto;
import ru.otus.igorr.books.lesson25.dto.NoteDto;
import ru.otus.igorr.books.lesson25.service.facade.ServicesFacade;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final ServicesFacade services;

    @GetMapping("/book/list")
    String listPage(Model model) {

        val books = getBookList();

        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/book/authors")
    String authorPage(@RequestParam String id, Model model) {

        val book = getBook(id);

        model.addAttribute("book", book);
        return "book/authors";
    }


    @GetMapping("/book/add")
    String addPage(Model model) {
        model.addAttribute("authors", getAuthorList());
        model.addAttribute("genres", getGenreList());
        return "book/add";
    }

    @PostMapping("/book/add")
    String addPage(@RequestParam String title,
                   @RequestParam String author,
                   @RequestParam String genre,
                   @RequestParam String description,
                   Model model) {

        val book = new BookDto
                .Builder()
                .title(title)
                .authorList(Arrays.asList(getAuthor(author)))
                .genre(getGenre(genre))
                .description(description)
                .build();

        services.addBook(book);

        model.addAttribute("books", getBookList());
        return "book/list";
    }

    @GetMapping("/book/view")
    String viewPage(@RequestParam String id, Model model) {

        model.addAttribute("book", getBook(id));
        model.addAttribute("readOnly", true);
        return "book/edit";
    }

    @PostMapping("/book/edit")
    String editPage(@RequestParam String id, Model model) {

        model.addAttribute("book", getBook(id));
        model.addAttribute("readOnly", false);
        return "book/edit";
    }

    @PostMapping("/book/save")
    String savePage(@RequestParam String id, Model model) {

        model.addAttribute("book", getBook(id));
        model.addAttribute("readOnly", true);
        return "book/edit";
    }


    @GetMapping("/book/comments")
    String commentsPage(@RequestParam String bookId, Model model) {

        BookDto book = getBook(bookId);
        List<NoteDto> notes = getNoteList(bookId);

        model.addAttribute("book", book);
        model.addAttribute("notes", notes);
        return "book/comments";
    }


    @GetMapping("/book/addnote")
    String addNotePage(@RequestParam String bookId,
                       Model model) {
        model.addAttribute("book", getBook(bookId));
        return "book/addnote";
    }

    @PostMapping("/book/addnote")
    String addNotePage(
            @RequestParam String bookId,
            @RequestParam String text,
            Model model) {

        NoteDto noteDto = new NoteDto();
        noteDto.setBookId(bookId);
        noteDto.setText(text);

        services.addBookNote(noteDto);

        BookDto book = getBook(bookId);
        List<NoteDto> notes = getNoteList(bookId);

        model.addAttribute("book", book);
        model.addAttribute("notes", notes);

        return "book/comments";
    }


    // TODO: 23.06.2019 Задача на развитие:
    //  Перейти на полный реактивный стек (убрать .block())

    private BookDto getBook(String id) {
        return services.getBook(id);
    }

    private AuthorDto getAuthor(String authorId) {
        return services.getAuthor(authorId);
    }

    private GenreDto getGenre(String genreId) {
        return services.getGenre(genreId);
    }

    private List<GenreDto> getGenreList() {
        return services.getGenreList();
    }

    private List<AuthorDto> getAuthorList() {
        return services.getAuthorList();
    }

    private List<BookDto> getBookList() {
        return services.getBookList();
    }

    private List<NoteDto> getNoteList(String bookId) {
        return services.getBookNoteList(bookId);
    }

}
