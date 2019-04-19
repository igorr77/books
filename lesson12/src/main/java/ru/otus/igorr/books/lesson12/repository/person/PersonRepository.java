package ru.otus.igorr.books.lesson12.repository.person;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson12.domain.person.Person;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {


    @Query("{name: ?0}")
    List<Person> findByThePersonsName(String firstname);

}
