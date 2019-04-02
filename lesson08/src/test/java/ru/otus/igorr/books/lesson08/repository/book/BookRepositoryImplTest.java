package ru.otus.igorr.books.lesson08.repository.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson08.domain.author.Author;
import ru.otus.igorr.books.lesson08.domain.author.AuthorName;
import ru.otus.igorr.books.lesson08.domain.book.Book;
import ru.otus.igorr.books.lesson08.domain.book.Note;
import ru.otus.igorr.books.lesson08.domain.genre.Genre;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryImplTest {

    private Book expectedBook;
    private List<Author> authorList;
    private Genre genre;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    NoteRepository noteRepository;

    @BeforeEach
    void setUp() {
        prepareAuthor();
        prepareGenre();

        expectedBook = new Book();
        expectedBook.setTitle("Title");
        expectedBook.setAuthor(authorList);
        expectedBook.setGenre(genre);
        expectedBook.setDescription("Description");
        bookRepository.save(expectedBook);
    }

    @Test
    void getById() {
        Book actualBook = bookRepository.getById(1);
        int breakPoint = 0;
        assertEquals(1, actualBook.getId());
    }

    @Test
    void saveTest() {
        // setUp()
    }

    @Test
    void getList() {
        // TODO: 02.04.2019  
    }

    @Test
    void delete() {
        // TODO: 02.04.2019  
    }

    @Test
    void addNoteTest() {
        Note note = new Note();
        note.setNote("Note");
        note.setOwner(expectedBook);
        noteRepository.add(note);

        Book actualBook = bookRepository.getById(expectedBook.getId());

        int breakPoint = 0;

        assertAll( () -> assertEquals(expectedBook.getId(), actualBook.getId()),
                   () -> assertNotNull(actualBook.getNote())
                );
    }

    private void prepareAuthor(){
        AuthorName authorName = new AuthorName();
        authorName.setFirstName("FirstName");
        authorName.setSurName("SurName");
        authorName.setLastName("LastName");

        Author author = new Author();
        author.setName(authorName);

        authorList = new ArrayList<>();
        authorList.add(author);
    }

    private void prepareGenre(){
        genre = new Genre();
        genre.setName("Genre Name");
        genre.setDescription("Genre Description");
    }

}