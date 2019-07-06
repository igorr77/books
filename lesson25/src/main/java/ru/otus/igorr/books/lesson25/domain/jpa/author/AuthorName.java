package ru.otus.igorr.books.lesson25.domain.jpa.author;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class AuthorName {

    private String firstName;
    private String surName;
    private String lastName;

}
