package ru.otus.igorr.books.lesson23.service.security;

import ru.otus.igorr.books.lesson23.domain.security.User;

public interface UserService {
    User getUser(String username);
}
