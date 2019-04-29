package ru.otus.igorr.books.lesson12.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoteDto {
    private String id;
    private String bookId;
    private String note;

    public NoteDto(String bookId, String note) {
        this.bookId = bookId;
        this.note = note;
    }

    @Override
    public String toString() {
        return "NoteDto{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", note='" + note + '\'' +
                '}';
    }
}
