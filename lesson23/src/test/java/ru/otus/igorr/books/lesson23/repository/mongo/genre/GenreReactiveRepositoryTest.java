package ru.otus.igorr.books.lesson23.repository.mongo.genre;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.igorr.books.lesson23.domain.mongo.genre.Genre;
import ru.otus.igorr.books.lesson23.repository.abstracts.AbstractRepositoryTest;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static ru.otus.igorr.books.lesson23.utils.Constant.NOT_FOUND_DOCUMENT_ID;


public class GenreReactiveRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private GenreRepository repository;

    @Test
    @DisplayName("saveTest")
    public void saveTest() {
        Genre genre = repository.save(new Genre(null, "Genre.Name", "Description"));

        assertNotNull(genre.getId());
    }

    @Test
    @DisplayName("findAllTest")
    public void findAllTest() {
        List<Genre> genres = repository.findAll();
        genres.stream()
                .forEach(genre -> assertNotNull(genre.getId()));

    }

    @Test
    @DisplayName("findByIdTest")
    public void findByIdTest() {
        Genre genre = repository.findById("1").orElse(Genre.empty());

        assertNotEquals(genre.getId(), NOT_FOUND_DOCUMENT_ID);

    }
}