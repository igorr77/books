package ru.otus.igorr.books.lesson08.domain.author;


import ru.otus.igorr.books.lesson08.domain.genre.Genre;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private int id;

    private AuthorName name;

    @OneToMany
    private List<Genre> genre;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AuthorName getName() {
        return name;
    }

    public void setName(AuthorName name) {
        this.name = name;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }
}
