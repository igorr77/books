package ru.otus.igorr.books.lesson12.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreDto {

    private String id;

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
