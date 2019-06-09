package ru.otus.igorr.books.lesson20.repository.author;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson20.domain.author.Author;

@Repository
public interface AuthorReactiveRepository extends ReactiveMongoRepository<Author, String> {
}
