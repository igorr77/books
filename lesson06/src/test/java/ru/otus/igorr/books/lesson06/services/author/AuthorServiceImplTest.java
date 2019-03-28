package ru.otus.igorr.books.lesson06.services.author;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson06.domain.Author;
import ru.otus.igorr.books.lesson06.exceptions.AuthorNotFoundException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    void saveInsertTest() {
        Author author = new Author("FirstnameTest", "SurnameTest", "LastnameTest", "QQ");
        assertNotEquals(0, service.save(author));
    }

    @Test
    void saveUpdateTest() {
        Author author = new Author("FirstnameUpdateTest", "SurnameUpdateTest", "LastnameUpdateTest", "YY");
        author.setId(2);
        assertEquals(2, service.save(author));
    }


    @Test
    void deleteTest() {
        Author author = new Author("DeleteTest", "DeleteTest", "DeleteTest", "DD");
        int createId = service.save(author);
        author.setId(createId);
        assertEquals(1, service.delete(author));

    }

    @Test
    void getList() {
        List<Author> authorList = service.getList("");
        int i = 0;
    }

    @Test
    void maxTest() {
        assertNotNull(service.getMaxId());
    }
}