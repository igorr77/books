package ru.otus.igorr.books.lesson22.repository.security;

import ru.otus.igorr.books.lesson22.domain.security.User;

public interface UserRepositoryCustom {
    User findByUsername(String username);
}
