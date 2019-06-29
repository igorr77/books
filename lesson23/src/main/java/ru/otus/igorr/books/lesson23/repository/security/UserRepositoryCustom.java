package ru.otus.igorr.books.lesson23.repository.security;

import ru.otus.igorr.books.lesson23.domain.security.User;

public interface UserRepositoryCustom {
    User findByUsername(String username);
}
