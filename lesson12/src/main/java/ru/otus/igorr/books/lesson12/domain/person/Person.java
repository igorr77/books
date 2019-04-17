package ru.otus.igorr.books.lesson12.domain.person;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Getter
@Setter
public class Person {

    @Id
    private String id;
    private String name;

}
