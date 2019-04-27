package ru.otus.spring07.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private int house;
    private int flat;
}
