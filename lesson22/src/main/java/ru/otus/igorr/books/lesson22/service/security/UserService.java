package ru.otus.igorr.books.lesson22.service.security;

import ru.otus.igorr.books.lesson22.domain.security.User;

public interface UserService {
    User getUser(String username);
}
