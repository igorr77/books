package ru.otus.igorr.books.lesson06.domain;

public class Genre {
    int id;
    String genre;
    String description;

    public Genre() {

    }

    public Genre(String genre, String description) {
        this.genre = genre;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
