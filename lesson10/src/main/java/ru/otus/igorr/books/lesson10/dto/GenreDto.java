package ru.otus.igorr.books.lesson10.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreDto {

    private long id;

    private String name;

    private String description;


    @Override
    public String toString() {
        return "GenreDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
