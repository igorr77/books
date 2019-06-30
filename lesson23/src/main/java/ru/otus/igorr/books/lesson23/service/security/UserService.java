package ru.otus.igorr.books.lesson23.service.security;

import ru.otus.igorr.books.lesson23.domain.mongo.security.User;

public interface UserService {
    User getUser(String username);
}
