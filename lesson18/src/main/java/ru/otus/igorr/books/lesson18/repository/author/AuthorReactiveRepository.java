package ru.otus.igorr.books.lesson18.repository.author;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson18.domain.author.Author;

@Repository
public interface AuthorReactiveRepository extends ReactiveMongoRepository<Author, String> {
}
