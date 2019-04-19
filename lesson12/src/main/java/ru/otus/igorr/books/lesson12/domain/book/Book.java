package ru.otus.igorr.books.lesson12.domain.book;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import ru.otus.igorr.books.lesson12.domain.author.Author;
import ru.otus.igorr.books.lesson12.domain.genre.Genre;

import java.util.List;

@Document(collection = "Book")
@Getter
@Setter
public class Book {
    @Id
    private String id;

    @Field("title")
    private String title;

    // У книги много авторов, у автора много книг,
    // но не настолько много, чтобы использовать LAZY
    /*
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, targetEntity = Author.class)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "BOOK_ID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID")
    )
    */
    @DBRef
    private List<Author> authors;


    //@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @DBRef
    private Genre genre;

    //@Column(name = "Description")
    @Field("description")
    private String description;

    // Одна книга - много комментов,
    // а раз много, то LAZY
    //@OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval = true)
    @DBRef
    private List<Note> notes;

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
