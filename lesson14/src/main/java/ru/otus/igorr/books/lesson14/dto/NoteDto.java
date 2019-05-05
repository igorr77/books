package ru.otus.igorr.books.lesson14.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoteDto {
    private String id;
    private String bookId;
    private String text;

    public NoteDto(String bookId, String text) {
        this.bookId = bookId;
        this.text = text;
    }

    @Override
    public String toString() {
        return "NoteDto{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", text='" + text + '\'' +
                '}';
    }
}
