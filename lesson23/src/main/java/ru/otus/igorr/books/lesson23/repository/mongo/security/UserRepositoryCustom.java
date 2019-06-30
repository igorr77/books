package ru.otus.igorr.books.lesson23.repository.mongo.security;

import ru.otus.igorr.books.lesson23.domain.mongo.security.User;

public interface UserRepositoryCustom {
    User findByUsername(String username);
}
