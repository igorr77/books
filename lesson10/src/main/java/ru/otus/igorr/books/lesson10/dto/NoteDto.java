package ru.otus.igorr.books.lesson10.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteDto {
    private long id;
    private long bookId;
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
