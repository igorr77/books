package ru.otus.igorr.books.lesson12.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthorDto {
    private String id;
    private String firstName;
    private String lastName;
    private String surName;
    private List<GenreDto> genreList;
    private List<BookDto> bookList;


    @Override
    public String toString() {
        return "AuthorDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", surName='" + surName + '\'' +
                ", genreList=" + genreList +
                '}';
    }
}
