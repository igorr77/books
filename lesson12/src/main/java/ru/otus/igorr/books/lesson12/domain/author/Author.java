package ru.otus.igorr.books.lesson12.domain.author;


import lombok.Getter;
import lombok.Setter;
import ru.otus.igorr.books.lesson12.domain.book.Book;
import ru.otus.igorr.books.lesson12.domain.genre.Genre;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "author")
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private AuthorName name;

    //@ManyToMany(mappedBy = "authorList", cascade = CascadeType.PERSIST)
    @ManyToMany(targetEntity = Book.class, fetch = FetchType.LAZY)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "AUTHOR_ID"),
            inverseJoinColumns = @JoinColumn(name = "BOOK_ID")
    )
    private Set<Book> books = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Genre> genre;


}
