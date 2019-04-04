package ru.otus.igorr.books.lesson08.domain.book;

import lombok.Getter;
import lombok.Setter;
import ru.otus.igorr.books.lesson08.domain.author.Author;
import ru.otus.igorr.books.lesson08.domain.genre.Genre;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "book_id")
    private int id;

    @Column(name = "title")
    private String title;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "book_author_ref")
    private List<Author> authorList;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderColumn(name = "name")
    private Genre genre;

    @Column(name = "Description")
    private String description;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<Note> noteList;


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
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

        if (!this.genre.equals(other.getGenre())) {
            return false;
        }
        if (!this.title.equals(other.getTitle())) {
            return false;
        }
        return true;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
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

        if (!this.genre.equals(other.getGenre())) {
            return false;
        }
        if (!this.title.equals(other.getTitle())) {
            return false;
        }

        return true;
    }
}
