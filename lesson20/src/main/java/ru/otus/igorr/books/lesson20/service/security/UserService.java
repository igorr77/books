package ru.otus.igorr.books.lesson20.service.security;

import ru.otus.igorr.books.lesson20.domain.security.User;

public interface UserService {
    User getUser(String username);
}
