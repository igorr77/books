package ru.otus.spring07.dao;

import ru.otus.spring07.domain.Person;

public interface PersonRepository {

    Person getById(int id);
}
