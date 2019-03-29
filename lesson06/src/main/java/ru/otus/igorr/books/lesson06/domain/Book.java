package ru.otus.igorr.books.lesson06.domain;

public class Book {
    private int id;
    private int authorId;
    private String authorName;
    private int genreId;
    private String genreName;
    private String title;
    private String isbn;
    private int pages;
    private String description;


    public Book() {
    }

    public Book(int authorId, String authorName, int genreId, String genreName, String title, String isbn, int pages, String description) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.genreId = genreId;
        this.genreName = genreName;
        this.title = title;
        this.isbn = isbn;
        this.pages = pages;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", genreId=" + genreId +
                ", genreName='" + genreName + '\'' +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", pages=" + pages +
                ", description='" + description + '\'' +
                '}';
    }
}
