package ru.otus.igorr.books.lesson12.domain.author;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import ru.otus.igorr.books.lesson12.domain.genre.Genre;

import java.util.Arrays;
import java.util.List;

import static ru.otus.igorr.books.lesson12.utils.Constant.NOT_FOUND_DOCUMENT_ID;

@Document(collection = "Author")
@Getter
@Setter
@NoArgsConstructor
public class Author {

    @Id
    private String id;

    @Field("name")
    private AuthorName name;

    private static Author emptyInstance;

    public static Author empty() {
        if (emptyInstance == null) {
            emptyInstance = new Author();
            emptyInstance.setId(NOT_FOUND_DOCUMENT_ID);
        }
        return emptyInstance;
    }


    public Author(String id, AuthorName name, Genre... genres) {
        this.id = id;
        this.name = name;
        this.genres = Arrays.asList(genres);
    }

    @DBRef
    private List<Genre> genres;

}
