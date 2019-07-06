package ru.otus.igorr.books.lesson25.service.security;

import ru.otus.igorr.books.lesson25.domain.mongo.security.User;

public interface UserService {
    User getUser(String username);
}
