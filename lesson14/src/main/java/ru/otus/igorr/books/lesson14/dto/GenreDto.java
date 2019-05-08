package ru.otus.igorr.books.lesson14.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenreDto {

    private String id;

    private String name;

    private String description;


    public GenreDto(String id) {
        this.id = id;
    }

    public GenreDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "GenreDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
