package ru.otus.igorr.books.lesson18.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    private String id;
    private String firstName;
    private String lastName;
    private String surName;
    private List<GenreDto> genreList;
    private List<BookDto> bookList;


    public AuthorDto(String id) {
        this.id = id;
    }

    public AuthorDto(String firstName, String lastName, String surName, List<GenreDto> genreList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.genreList = genreList;
    }

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
