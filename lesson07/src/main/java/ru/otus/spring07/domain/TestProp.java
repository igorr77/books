package ru.otus.spring07.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestProp {
    @Id
    @GeneratedValue
    private int id;

    private String testProp;
}
