package ru.otus.igorr.books.lesson12.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.igorr.books.lesson12.dto.AuthorDto;
import ru.otus.igorr.books.lesson12.dto.BookDto;
import ru.otus.igorr.books.lesson12.dto.GenreDto;
import ru.otus.igorr.books.lesson12.dto.NoteDto;
import ru.otus.igorr.books.lesson12.service.book.BookService;
import ru.otus.igorr.books.lesson12.service.genre.GenreService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ShellComponent
public class NoteCommands {

    private static final String OFFSET = "----------------------------\n\n";

    private final BookService bookService;

    @Autowired
    public NoteCommands(BookService bookService, GenreService genreService) {
        this.bookService = bookService;
    }

    @ShellMethod(key = "note", value = "Show book's note")
    public String note(@ShellOption("--id") String id) {

        NoteDto note = bookService.getNote(id);
        return OFFSET + note.toString();
    }


    @ShellMethod(key = "noteList", value = "Show book's note list")
    public String noteList(@ShellOption("--bookId") String bookId) {

        List<NoteDto> list = bookService.getNoteList(bookId);
        return OFFSET + list.stream().map(note -> note.toString()).collect(Collectors.joining("\n"));
    }

    @ShellMethod(key = "noteAdd", value = "Add book's note")
    public String noteAdd(@ShellOption("--bookId") String bookId,
                          @ShellOption("--note") String note
    ) {

        NoteDto dto = new NoteDto(bookId, note);
        bookService.addNote(dto);

        List<NoteDto> list = bookService.getNoteList(bookId);
        return OFFSET + list.stream().map(n -> n.toString()).collect(Collectors.joining("\n"));
    }

    @ShellMethod(key = "noteDel", value = "Delete note")
    public void noteDel(@ShellOption("--id") String id) {

        bookService.deleteNote(id);

    }


}
