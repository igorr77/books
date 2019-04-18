package ru.otus.igorr.books.lesson12.repository.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.otus.igorr.books.lesson12.domain.person.Person;

import java.util.List;

@SpringBootTest
//@DataMongoTest
class PersonRepositoryTest {


    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    PersonRepository repository;


    @BeforeEach
    void StartUp() {
        Person person = preparePerson();
        mongoTemplate.save(person);
    }

    private Person preparePerson() {
        Person person = new Person();

        person.setId("123");
        person.setName("TestName");


        return person;
    }

    @Test
    void findAllTest() {


        List<Person> personList1 = repository.findByThePersonsName("TestName");

        int breakPoint = 0;


    }


}