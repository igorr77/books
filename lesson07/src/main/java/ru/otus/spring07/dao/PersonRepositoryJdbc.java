package ru.otus.spring07.dao;

import org.springframework.stereotype.Repository;
import ru.otus.spring07.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PersonRepositoryJdbc implements PersonRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Person getById(int id) {
        return em.find(Person.class, id);
    }
}
