package ru.otus.igorr.books.lesson10.domain.book;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "Note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book owner;

}
