package ru.otus.igorr.books.lesson12.domain.author;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import ru.otus.igorr.books.lesson12.domain.book.Book;
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

    private static Author instance;

    public static Author empty() {
        if (instance == null) {
            instance = new Author();
            instance.setId(NOT_FOUND_DOCUMENT_ID);
        }
        return instance;
    }


    public Author(String id, AuthorName name, Genre... genres) {
        this.id = id;
        this.name = name;
        this.genres = Arrays.asList(genres);
    }

    /*
    @ManyToMany(targetEntity = Book.class, fetch = FetchType.LAZY)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "AUTHOR_ID"),
            inverseJoinColumns = @JoinColumn(name = "BOOK_ID")
    )
    private Set<Book> books = new HashSet<>();
    */
    //@DBRef
    //private List<Book> books;

    /*
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Genre> genre;
    */
    @DBRef
    private List<Genre> genres;


}
