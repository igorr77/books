package ru.otus.igorr.books.lesson15.dto;

import org.junit.jupiter.api.Test;
import ru.otus.igorr.books.lesson15.domain.book.Book;
import ru.otus.igorr.books.lesson15.domain.book.Note;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class NoteDtoConverterTest {

    private static final String OWNER_ID = "111L";
    private static final String NOTE_ID = "222L";

    private DtoConverter<Note, NoteDto> converter = new NoteDtoConverter();

    @Test
    void convertTest() {
        Note note = prepareNote(0);
        NoteDto dto = converter.convert(note);

        assertAll(
                () -> assertNotNull(dto),
                () -> assertEquals(note.getId(), dto.getId()),
                () -> assertEquals(note.getBook().getId(), dto.getBookId()),
                () -> assertTrue(note.getNote().equals(dto.getText()))
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
        dto.setText("Note.Text: " + n);
        return dto;
    }
}