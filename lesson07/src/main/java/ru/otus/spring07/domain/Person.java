package ru.otus.spring07.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Persons")
public class Person {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "PersonName")
    private String name;

    @OneToMany
    @Embedded
    private List<Email> email;

    @ManyToOne
    private TestProp testProp;

    public Person(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
