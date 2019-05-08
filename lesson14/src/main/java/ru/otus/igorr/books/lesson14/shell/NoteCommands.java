package ru.otus.igorr.books.lesson14.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.igorr.books.lesson14.dto.NoteDto;
import ru.otus.igorr.books.lesson14.service.book.BookService;
import ru.otus.igorr.books.lesson14.service.genre.GenreService;

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

    @ShellMethod(key = "text", value = "Show book's text")
    public String note(@ShellOption("--id") String id) {

        NoteDto note = bookService.getNote(id);
        return OFFSET + note.toString();
    }


    @ShellMethod(key = "noteList", value = "Show book's text list")
    public String noteList(@ShellOption("--bookId") String bookId) {

        List<NoteDto> list = bookService.getNoteList(bookId);
        return OFFSET + list.stream().map(note -> note.toString()).collect(Collectors.joining("\n"));
    }

    @ShellMethod(key = "noteAdd", value = "Add book's text")
    public String noteAdd(@ShellOption("--bookId") String bookId,
                          @ShellOption("--text") String note
    ) {

        NoteDto dto = new NoteDto(bookId, note);
        bookService.addNote(dto);

        List<NoteDto> list = bookService.getNoteList(bookId);
        return OFFSET + list.stream().map(n -> n.toString()).collect(Collectors.joining("\n"));
    }

    @ShellMethod(key = "noteDel", value = "Delete text")
    public void noteDel(@ShellOption("--id") String id) {

        bookService.deleteNote(id);

    }


}
