package ru.otus.igorr.books.lesson10.domain.book;

import lombok.Getter;
import lombok.Setter;
import ru.otus.igorr.books.lesson10.domain.author.Author;
import ru.otus.igorr.books.lesson10.domain.genre.Genre;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "book_author_ref")
    private List<Author> authorList;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
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
