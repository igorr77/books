package ru.otus.spring07.domain;

public enum EmailType {

    WRONG("WRONG"),
    PEROSN("Person"),
    WORK("Work");

    private final String code;

    EmailType(String code) {
        this.code = code;
    }
}
