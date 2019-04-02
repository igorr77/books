package ru.otus.igorr.books.lesson08.domain.book;

import ru.otus.igorr.books.lesson08.domain.author.Author;
import ru.otus.igorr.books.lesson08.domain.genre.Genre;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "Title")
    private String title;

    @OneToOne
    private Genre genre;

    @OneToMany(cascade = CascadeType.ALL)
    List<Author> author;

    @Column(name = "Description")
    private String description;

    @OneToMany(mappedBy = "owner")
    private List<Note> note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Note> getNote() {
        return note;
    }

    public void setNote(List<Note> note) {
        this.note = note;
    }
}
