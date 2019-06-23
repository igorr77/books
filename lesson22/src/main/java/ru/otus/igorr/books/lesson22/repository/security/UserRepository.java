package ru.otus.igorr.books.lesson22.repository.security;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson22.domain.security.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>, UserRepositoryCustom {
}
