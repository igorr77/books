package ru.otus.igorr.books.lesson20.service.security;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson20.domain.security.User;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {


    @Autowired
    UserService service;

    @ParameterizedTest
    @ValueSource(strings = {"admin", "view", "edit"})
    @DisplayName("get")
    void getByUsernameTest(String param) {
        User user = service.getUser(param);
        assertEquals("p"+param, user.getPassword());
    }

}