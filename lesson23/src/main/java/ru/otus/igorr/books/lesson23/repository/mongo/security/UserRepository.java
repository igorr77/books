package ru.otus.igorr.books.lesson23.repository.mongo.security;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson23.domain.mongo.security.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>, UserRepositoryCustom {
}
