package ru.otus.igorr.books.lesson18.controllers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseId {
    private String id;

    public ResponseId(String id) {
        this.id = id;
    }
}
