package ru.otus.igorr.books.lesson08.repository.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson08.domain.author.Author;
import ru.otus.igorr.books.lesson08.domain.author.AuthorName;
import ru.otus.igorr.books.lesson08.domain.book.Book;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookRepositoryImplTest {

    private Book expectedBook;

    @Autowired
    BookRepository repository;

    @BeforeEach
    void setUp() {
        // TODO: 02.04.19 рабочий вариант
        Author author = new Author();
        AuthorName authorName = new AuthorName();
        authorName.setFirstName("FirstName");
        authorName.setSurName("SurName");
        authorName.setLastName("LastName");
        author.setName(authorName);
        List<Author> authorList = new ArrayList<>();
        authorList.add(author);

        expectedBook = new Book();
        expectedBook.setTitle("Title");
        expectedBook.setAuthor(authorList);
        expectedBook.setDescription("Description");
        repository.save(expectedBook);
    }

    @Test
    void getById() {
        Book actualBook = repository.getById(1);
        int breakPoint = 0;
        assertEquals(1, actualBook.getId());
    }

    @Test
    void saveTest() {

        /*
        List<Note> noteList = new ArrayList<>();

        Book book = new Book();
        book.setTitle("Title");
        book.setNote(noteList);
         */


    }

    @Test
    void getList() {
    }

    @Test
    void delete() {
    }

    @Test
    void addNote() {
    }
}