package ru.otus.igorr.books.lesson12.service.genre;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson12.dto.GenreDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.otus.igorr.books.lesson12.utils.Constant.NOT_FOUND_DOCUMENT_ID;

@SpringBootTest
class GenreServiceImplTest {

    @Autowired
    GenreService service;

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("getById")
    void getByIdTest(String param) {
        GenreDto genre = service.getById(param);
        assertAll(
                () -> assertNotNull(genre),
                () -> assertNotEquals(NOT_FOUND_DOCUMENT_ID, genre.getId())
        );
    }

    @Test
    void addTest() {
    }

    @ParameterizedTest
    @ValueSource(strings = "999L")
    void deleteByIdTest(String param) {
        GenreDto genreBeforDel = service.getById(param);
        service.delete(param);
        GenreDto delGenreAfterDel = service.getById(param);
        assertAll(
                () -> assertEquals(param, genreBeforDel.getId()),
                () -> assertEquals(NOT_FOUND_DOCUMENT_ID, delGenreAfterDel.getId())
        );
    }


    @ParameterizedTest
    @ValueSource(strings = "888L")
    void deleteTest(String param) {
        GenreDto genreBeforDel = service.getById(param);
        GenreDto genreForDel = new GenreDto(param, "Test", "Test");
        service.delete(genreForDel);
        GenreDto delGenreAfterDel = service.getById(param);
        assertAll(
                () -> assertEquals(param, genreBeforDel.getId()),
                () -> assertEquals(NOT_FOUND_DOCUMENT_ID, delGenreAfterDel.getId())
        );
    }


    @Test
    void getListTest() {
        List<GenreDto> dtoList = service.getList();
        assertAll(
                () -> assertNotNull(dtoList),
                () -> assertTrue(dtoList.size() >= 3)
        );


    }

    @Test
    void getListByNameTest() {
        String mask = "Get\\..*";
        List<GenreDto> dtoList = service.getListByName(mask);
        assertAll(
                () -> assertNotNull(dtoList),
                () -> assertTrue(dtoList.size() == 3)
        );
    }
}