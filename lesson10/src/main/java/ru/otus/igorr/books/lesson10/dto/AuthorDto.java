package ru.otus.igorr.books.lesson10.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthorDto {
    private long id;
    private String firstName;
    private String lastName;
    private String surName;
    private List<GenreDto> genreList;


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
