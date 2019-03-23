package ru.otus.igorr.books.lesson06.dao.genre;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson06.domain.Genre;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GenreDaoImplTest {

    @Autowired
    GenreDao dao;

    @Test
    void getByIdTest() {
        Optional<Genre> genre = dao.getById(1);
        System.out.println(genre);
    }

    @Test
    void insert() {
    }

    @Test
    void update() {
    }
}