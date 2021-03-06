package ru.otus.igorr.books.lesson23.domain.jpa.book;

import lombok.Getter;
import lombok.Setter;
import ru.otus.igorr.books.lesson23.domain.jpa.author.Author;
import ru.otus.igorr.books.lesson23.domain.jpa.genre.Genre;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    // У книги много авторов, у автора много книг,
    // но не настолько много, чтобы использовать LAZY
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, targetEntity = Author.class)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "BOOK_ID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID")
    )
    private Set<Author> authors = new HashSet<>();


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Genre genre;

    @Column(name = "Description")
    private String description;

    // Одна книга - много комментов,
    // а раз много, то LAZY
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval = true)
    private Set<Note> notes;

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
