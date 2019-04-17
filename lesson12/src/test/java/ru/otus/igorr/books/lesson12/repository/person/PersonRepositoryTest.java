package ru.otus.igorr.books.lesson12.repository.person;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson12.domain.person.Person;

import java.util.List;

@SpringBootTest
class PersonRepositoryTest {


    @Autowired
    PersonRepository repository;

    @Test
    void findAllTest(){

        List<Person> personList = repository.findAll();

        Person person = repository.findByThePersonsFirstName("")

        int breakPoint = 0;


    }


}