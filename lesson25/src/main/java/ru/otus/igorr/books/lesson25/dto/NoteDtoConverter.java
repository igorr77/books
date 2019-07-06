package ru.otus.igorr.books.lesson25.dto;

import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson25.domain.mongo.book.Book;
import ru.otus.igorr.books.lesson25.domain.mongo.book.Note;

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
