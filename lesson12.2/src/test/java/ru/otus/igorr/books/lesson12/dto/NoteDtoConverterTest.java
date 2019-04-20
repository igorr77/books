package ru.otus.igorr.books.lesson12.dto;

import org.junit.jupiter.api.Test;
import ru.otus.igorr.books.lesson12.domain.book.Book;
import ru.otus.igorr.books.lesson12.domain.book.Note;
import ru.otus.igorr.books.lesson12.dto.DtoConverter;
import ru.otus.igorr.books.lesson12.dto.NoteDto;
import ru.otus.igorr.books.lesson12.dto.NoteDtoConverter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class NoteDtoConverterTest {

    private static final String OWNER_ID = "111L";
    private static final String NOTE_ID = "222L";

    //@Autowired
    private DtoConverter<Note, NoteDto> converter = new NoteDtoConverter();

    @Test
    void convertTest() {
        Note note = prepareNote(0);
        NoteDto dto = converter.convert(note);

        assertAll(
                () -> assertNotNull(dto),
                () -> assertEquals(note.getId(), dto.getId()),
                () -> assertEquals(note.getBook().getId(), dto.getBookId()),
                () -> assertTrue(note.getNote().equals(dto.getNote()))
        );
    }

    @Test
    void fillTest() {
        Note note = converter.fill(prepareDto(0));

        int breakPoint = 0;
    }

    @Test
    void convertListTest() {
        List<Note> noteList = new ArrayList<>();
        noteList.add(prepareNote(1));
        noteList.add(prepareNote(2));

        List<NoteDto> dtoList = converter.convertList(noteList);

        int breakPoint = 0;
    }

    @Test
    void fillListTest() {
    }

    private Note prepareNote(long n) {
        Book book = new Book();
        book.setId(OWNER_ID + n);

        Note note = new Note();
        note.setId(NOTE_ID + n);
        note.setNote("Note");
        note.setBook(book);
        return note;
    }

    private NoteDto prepareDto(long n) {
        NoteDto dto = new NoteDto();
        dto.setId(NOTE_ID + n);
        dto.setBookId(OWNER_ID + n);
        dto.setNote("Note.Text: " + n);
        return dto;
    }
}