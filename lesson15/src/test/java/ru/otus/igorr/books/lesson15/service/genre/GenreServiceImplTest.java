package ru.otus.igorr.books.lesson15.service.genre;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson15.dto.GenreDto;
import ru.otus.igorr.books.lesson15.execptions.DeleteReferenceRecordException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.otus.igorr.books.lesson15.utils.Constant.NOT_FOUND_DOCUMENT_ID;

@SpringBootTest
class GenreServiceImplTest {

    @Autowired
    GenreService service;

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("get")
    void getByIdTest(String param) {
        GenreDto genre = service.get(param);
        assertAll(
                () -> assertNotNull(genre),
                () -> assertNotEquals(NOT_FOUND_DOCUMENT_ID, genre.getId())
        );
    }

    @Test
    void deleteRefGenreExceptionTest() {
        assertThrows(DeleteReferenceRecordException.class, () -> service.delete("1"));
    }

    @ParameterizedTest
    @ValueSource(strings = "999L")
    void deleteByIdTest(String param) {
        GenreDto genreBeforDel = service.get(param);
        service.delete(param);
        GenreDto delGenreAfterDel = service.get(param);
        assertAll(
                () -> assertEquals(param, genreBeforDel.getId()),
                () -> assertEquals(NOT_FOUND_DOCUMENT_ID, delGenreAfterDel.getId())
        );
    }


    @ParameterizedTest
    @ValueSource(strings = "888L")
    void deleteTest(String param) {
        GenreDto genreBeforDel = service.get(param);
        GenreDto genreForDel = new GenreDto(param, "Test", "Test");
        service.delete(genreForDel);
        GenreDto delGenreAfterDel = service.get(param);
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
        String mask = "Д.*";
        List<GenreDto> dtoList = service.getListByName(mask);
        assertAll(
                () -> assertNotNull(dtoList),
                () -> assertTrue(dtoList.size() == 1)
        );
    }
}