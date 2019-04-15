package ru.otus.igorr.books.lesson10.service.author;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson10.dto.AuthorDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorServiceImplTest {

    @Autowired
    AuthorService authorService;

    @Test
    void add() {
    }

    @Test
    void getById() {
    }

    @Test
    void getByBook() {
    }

    @Test
    void getListTest() {
        List<AuthorDto> authorList = authorService.getList();

        int breakPoint = 0;
    }
}