package ru.otus.igorr.books.lesson18.dto;

import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson18.domain.book.Book;
import ru.otus.igorr.books.lesson18.domain.book.Note;

import java.util.ArrayList;
import java.util.List;

@Service("noteConverter")
public class NoteDtoConverter implements DtoConverter<Note, NoteDto> {

    @Override
    public NoteDto convert(Note note) {
        return entity2dto(note);
    }

    @Override
    public Note fill(NoteDto dto) {
        return dto2entity(dto);
    }

    @Override
    public List<NoteDto> convertList(final List<Note> entityList) {
        final List<NoteDto> dtoList = new ArrayList<>();
        entityList.forEach(note -> dtoList.add(entity2dto(note)));
        return dtoList;
    }

    @Override
    public List<Note> fillList(final List<NoteDto> dtoList) {
        final List<Note> noteList = new ArrayList<>();
        dtoList.forEach(dto -> noteList.add(dto2entity(dto)));
        return noteList;
    }

    private NoteDto entity2dto(Note note) {
        final NoteDto dto = new NoteDto();
        dto.setId(note.getId());
        dto.setBookId(note.getBook().getId());
        dto.setText(note.getNote());
        return dto;
    }

    private Note dto2entity(NoteDto dto) {
        final Note note = new Note();

        Book book = new Book();
        book.setId(dto.getBookId());

        note.setId(dto.getId());
        note.setNote(dto.getText());
        note.setBook(book);

        return note;
    }
}
