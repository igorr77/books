package ru.otus.igorr.books.lesson06.domain;

public class Book {
    private Long id;
    private Long authorId;
    private Long genreId;
    private String title;
    private String isbn;
    private int pages;
    private String description;

    public Book(Long authorId, Long genreId, String title, String isbn, int pages, String description) {
        this.authorId = authorId;
        this.genreId = genreId;
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
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
