package ru.otus.igorr.books.lesson08.domain.book;

import javax.persistence.*;

@Entity
public class Note {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "Note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book owner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Book getOwner() {
        return owner;
    }

    public void setOwner(Book owner) {
        this.owner = owner;
    }
}
