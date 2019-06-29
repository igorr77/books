package ru.otus.igorr.books.lesson23.repository.author;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson23.domain.author.Author;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String>, AuthorRepositoryCustom {

}
