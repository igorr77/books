package ru.otus.igorr.books.lesson08.repository.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson08.domain.author.Author;
import ru.otus.igorr.books.lesson08.domain.author.AuthorName;
import ru.otus.igorr.books.lesson08.domain.book.Book;
import ru.otus.igorr.books.lesson08.domain.book.Note;
import ru.otus.igorr.books.lesson08.domain.genre.Genre;
import ru.otus.igorr.books.lesson08.dto.BookDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryImplTest {

    private Book expectedBook;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    NoteRepository noteRepository;

    @BeforeEach
    void setUp() {
        expectedBook = new Book();
        expectedBook.setTitle("Title");
        expectedBook.setAuthorList(prepareAuthorList());
        expectedBook.setGenre(prepareGenre());
        expectedBook.setDescription("Description");
        //bookRepository.save(expectedBook);
    }

    @Test
    void getById() {

        int id = bookRepository.save(expectedBook);

        BookDto actualBook = bookRepository.getById(id);
        int breakPoint = 0;
        assertEquals(id, actualBook.getId());
    }

    @Test
    void saveTest() {
        // setUp()
    }

    @Test
    @Disabled
    void getList() {
        List<Book> list = bookRepository.getList();
        assertAll(() -> assertEquals(1, list.size()),
                  () -> assertEquals(expectedBook, list.get(0)));

    }

    @Test
    void delete() {

        int id = bookRepository.save(expectedBook);
        Book delBook = new Book();
        delBook.setId(id);
        bookRepository.delete(delBook);
        BookDto actualBook = bookRepository.getById(id);
        assertEquals(-1, actualBook.getId());
    }

    @Test
    void addNoteTest() {
        int id = bookRepository.save(expectedBook);

        Note note = new Note();
        note.setNote("Note");
        note.setOwner(expectedBook);
        noteRepository.add(note);

        BookDto actualBook = bookRepository.getById(expectedBook.getId());

        int breakPoint = 0;

        assertAll(() -> assertEquals(expectedBook.getId(), actualBook.getId()),
                  () -> assertNotNull(actualBook.getNoteList())
        );
    }

    private List<Author> prepareAuthorList() {
        AuthorName authorName = new AuthorName();
        authorName.setFirstName("FirstName");
        authorName.setSurName("SurName");
        authorName.setLastName("LastName");

        Author author = new Author();
        author.setName(authorName);

        List<Author> authorList = new ArrayList<>();
        authorList.add(author);

        return authorList;
    }

    private Genre prepareGenre() {
        Genre genre = new Genre();
        genre.setName("Genre Name");
        genre.setDescription("Genre Description");
        return genre;
    }

}