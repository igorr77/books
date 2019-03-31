package ru.otus.spring07.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Company")
public class Company {
    @Id
    @GeneratedValue
    private int id;

    private CompanyName name;


    @OneToOne
    @Embedded
    private Email email;

    @OneToMany
    @Embedded
    private List<Person> officer;
}
