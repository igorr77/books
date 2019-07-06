package ru.otus.igorr.books.lesson23.domain.mongo.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static ru.otus.igorr.books.lesson23.utils.Constant.NOT_FOUND_DOCUMENT_ID;

@Document(collection = "Note")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    private String id;

    @Field("text")
    private String note;

    @DBRef
    private Book book;

    private static Note emptyInstance;

    public static Note empty() {
        if (emptyInstance == null) {
            emptyInstance = new Note();
            emptyInstance.setId(NOT_FOUND_DOCUMENT_ID);
        }
        return emptyInstance;
    }

}
