package ru.otus.igorr.books.lesson12.domain.book;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Note")
@Getter
@Setter
public class Note {
    @Id
    private String id;

    @Field("note")
    private String note;

    @DBRef
    private Book book;

}
