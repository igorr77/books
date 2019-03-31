package ru.otus.igorr.books.lesson08.repository.genre;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import ru.otus.igorr.books.lesson08.domain.genre.Genre;


//@SpringBootTest
@DataJpaTest
@ContextConfiguration(classes = GenreRepositoryImpl.class)
class GenreRepositoryImplTest {


    @Autowired
    GenreRepository repository;

    @BeforeEach
    void setUp() {
        Genre genre = new Genre();
        genre.setName("Test Genre");
        genre.setDescription("Test Description");
        repository.save(genre);
    }

    @Test
    void getByIdTest() {
        Genre genre = repository.getById(1);
        int i = 0;
    }
}