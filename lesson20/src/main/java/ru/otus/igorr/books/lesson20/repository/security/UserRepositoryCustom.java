package ru.otus.igorr.books.lesson20.repository.security;

import ru.otus.igorr.books.lesson20.domain.security.User;

public interface UserRepositoryCustom {
    User findByUsername(String username);
}
