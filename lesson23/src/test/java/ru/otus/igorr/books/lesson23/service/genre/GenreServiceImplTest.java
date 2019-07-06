package ru.otus.igorr.books.lesson23.service.genre;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson23.dto.GenreDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GenreServiceImplTest {


    @Autowired
    GenreService service;

    @Test
    void listTest() {
        List<GenreDto> genres = service.getList();
        int breakPoint = 0;
    }
}