package ru.otus.igorr.books.lesson12.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteDto {
    private String id;
    private String bookId;
    private String note;

    @Override
    public String toString() {
        return "NoteDto{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", note='" + note + '\'' +
                '}';
    }
}
