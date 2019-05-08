package ru.otus.igorr.books.lesson14.domain.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import ru.otus.igorr.books.lesson14.domain.author.Author;
import ru.otus.igorr.books.lesson14.domain.genre.Genre;

import java.util.List;

import static ru.otus.igorr.books.lesson14.utils.Constant.NOT_FOUND_DOCUMENT_ID;

@Document(collection = "Book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private String id;

    @Field("title")
    private String title;

    @DBRef
    private List<Author> authors;

    @DBRef
    private Genre genre;

    @Field("description")
    private String description;


    private static Book emptyInstance;

    public static Book empty() {
        if (emptyInstance == null) {
            emptyInstance = new Book();
            emptyInstance.setId(NOT_FOUND_DOCUMENT_ID);
        }
        return emptyInstance;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        if (!Book.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final Book other = (Book) obj;

        /* Минимум */

        if (this.id != other.getId()) {
            return false;
        }
        if (this.genre == null && other.getGenre() != null) {
            return false;
        }

        if (this.genre != null && !this.genre.equals(other.getGenre())) {
            return false;
        }

        return this.title.equals(other.getTitle());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
