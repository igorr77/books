package ru.otus.igorr.books.lesson06.domain;

public class Book {
    private Long id;
    private Author author;
    private Genre genre;
    private String title;
    private String isbn;
    private int pages;
    private String description;


    public Book(Long id, Author author, Genre genre, String title, String isbn, int pages, String description) {
        this.id = id;
        this.author = author;
        this.genre = genre;
        this.title = title;
        this.isbn = isbn;
        this.pages = pages;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
