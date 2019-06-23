package ru.otus.igorr.books.lesson22.domain.author;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorName {

    private String firstName;
    private String surName;
    private String lastName;

}
