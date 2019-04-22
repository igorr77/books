package ru.otus.igorr.books.lesson12.repository.genre;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.igorr.books.lesson12.domain.genre.Genre;
import ru.otus.igorr.books.lesson12.repository.abstracts.AbstractRepositoryTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.otus.igorr.books.lesson12.utils.Constant.NOT_FOUND_DOCUMENT_ID;


@DisplayName("Test GenreRepository")
class GenreRepositoryTest extends AbstractRepositoryTest {

    private static final String DELETED_ID = "999L";

    @Autowired
    GenreRepository repository;

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    //@DisplayName("ttttttttttttttttttttttttttt")
    void findByIdTest(String param) {
        Genre genre = repository.findById(param).orElse(Genre.empty());
        assertEquals(param, genre.getId());
    }

    @Test
    void deleteTest() {
        Genre delGenre = new Genre();
        delGenre.setId(DELETED_ID);

        assertEquals(DELETED_ID, repository.findById(DELETED_ID).orElse(Genre.empty()).getId());
        repository.delete(delGenre);
        assertEquals(NOT_FOUND_DOCUMENT_ID, repository.findById(DELETED_ID).orElse(Genre.empty()).getId());

        int breakPoint = 0;
    }


    @Test
    void findAllTest() {
        List<Genre> list = repository.findAll();
        assertAll(
                () -> assertNotEquals(0, list.size()),
                () -> assertNotNull(list.get(2))
        );
    }

    private Genre prepareGenre(String id) {
        Genre genre = new Genre();
        genre.setId(id);
        genre.setName("Genre.Name.Test." + id);
        genre.setDescription("Genre.Description.Test." + id);
        return genre;
    }


}