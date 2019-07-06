package ru.otus.igorr.books.lesson25.service.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson25.domain.mongo.security.User;
import ru.otus.igorr.books.lesson25.repository.mongo.security.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {


    private final UserRepository repository;

    @Override
    public User getUser(String username) {
        User user = repository.findByUsername(username);
        LOG.debug(user.getUsername()+" "+user.getPassword()+" "+user.getRole());
        return user;
    }
}
