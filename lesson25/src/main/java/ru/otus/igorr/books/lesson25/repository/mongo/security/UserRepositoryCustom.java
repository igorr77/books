package ru.otus.igorr.books.lesson25.repository.mongo.security;

import ru.otus.igorr.books.lesson25.domain.mongo.security.User;

public interface UserRepositoryCustom {
    User findByUsername(String username);
}
