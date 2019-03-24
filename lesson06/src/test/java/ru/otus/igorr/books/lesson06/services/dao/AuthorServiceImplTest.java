package ru.otus.igorr.books.lesson06.services.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson06.exceptions.AuthorNotFoundException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AuthorServiceImplTest {


    @Autowired
    private AuthorService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getTest() {
        assertNotNull(service.get(2));
    }

    @Test
    void getExceptionTest() {
        assertThrows(AuthorNotFoundException.class, () -> service.get(0));
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }
}