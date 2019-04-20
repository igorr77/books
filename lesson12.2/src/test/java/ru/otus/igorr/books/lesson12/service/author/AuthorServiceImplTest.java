package ru.otus.igorr.books.lesson12.service.author;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson12.dto.AuthorDto;
import ru.otus.igorr.books.lesson12.service.author.AuthorService;

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
    void getListWithoutBooksTest() {
        List<AuthorDto> authorList = authorService.getListWithoutBooks();
        int breakPoint = 0;
    }

    @Test
    void getListWithBooksTest() {
        List<AuthorDto> authorList = authorService.getListWithBooks();
        int breakPoint = 0;
    }
}