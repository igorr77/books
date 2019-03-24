package ru.otus.igorr.books.lesson06.domain;

public class Author {
    private int id;
    private String firstName;
    private String surName;
    private String lastName;
    private String country;

    public Author() {

    }

    public Author(String firstName, String surName, String lastName, String country) {
        this.firstName = firstName;
        this.surName = surName;
        this.lastName = lastName;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
