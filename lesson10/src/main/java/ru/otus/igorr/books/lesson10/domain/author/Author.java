package ru.otus.igorr.books.lesson10.domain.author;


import lombok.Getter;
import lombok.Setter;
import ru.otus.igorr.books.lesson10.domain.genre.Genre;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private AuthorName name;

    @ManyToMany
    private List<Genre> genre;


}
