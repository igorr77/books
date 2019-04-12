package ru.otus.igorr.books.lesson10.repository.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ru.otus.igorr.books.lesson10.domain.author.Author;
import ru.otus.igorr.books.lesson10.domain.author.AuthorName;
import ru.otus.igorr.books.lesson10.domain.book.Book;
import ru.otus.igorr.books.lesson10.domain.genre.Genre;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class BookRepositoryTest {

    private static final Book EMPTY_BOOK = new Book();
    private static final long FIND_ID = 1L;
    private static final long DELETE_ID = 999L;

    @Autowired
    BookRepository bookRepository;


    @BeforeEach
    void setUp() {
        EMPTY_BOOK.setId(-1L);
    }

    @Test
    void findByIdTest() {
        Book actualBook = bookRepository.findById(FIND_ID).orElse(EMPTY_BOOK);
        assertEquals(FIND_ID, actualBook.getId());
    }

    @Test
    void deleteTest() {

        Book actualBook = bookRepository.findById(DELETE_ID).orElse(EMPTY_BOOK);

        Book delBook = new Book();
        delBook.setId(DELETE_ID);
        bookRepository.delete(delBook);

        Book deletedBook = bookRepository.findById(DELETE_ID).orElse(EMPTY_BOOK);

        assertAll(
                () -> assertEquals(DELETE_ID, actualBook.getId()),
                () -> assertEquals(EMPTY_BOOK.getId(), deletedBook.getId())
        );

    }

    @Test
    void findAllTest() {
        Page<Book> page = bookRepository.findAll(PageRequest.of(1, 2, new Sort(Sort.Direction.ASC, "id")));
        assertEquals(4L, page.getContent().get(1).getId());
    }

    @Test
    void addNoteTest() {
        Book book = prepareBook();
        //Book saveBook = bookRepository.save(book);

        Page<Book> page = bookRepository.findAll(PageRequest.of(1, 4, new Sort(Sort.Direction.ASC, "id")));

        int breakPoint = 0;
    }

    private Book prepareBook() {
        Book book = new Book();
        List<Author> authorList = prepareAuthorList(3);


        book.setTitle("Book.Title.AddNote");
        book.setAuthorList(authorList);
        book.setGenre(prepareGenre(1));
        book.setDescription("Book.Description");

        return book;
    }

    private Genre prepareGenre(int n) {
        Genre genre = new Genre();
        genre.setId(n);
        genre.setName("Book.Genre: " + n);
        genre.setDescription("Book.Description: " + n);
        return genre;
    }

    private List<Author> prepareAuthorList(int count) {
        List<Author> list = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            list.add(prepareAuthor(i));
        }
        return list;
    }

    private Author prepareAuthor(int i) {
        Author author = new Author();
        author.setId(i);
        author.setName(prepareAuthorName(i));
        author.setGenre(prepareGenreList(2));
        return author;
    }

    private List<Genre> prepareGenreList(int count) {
        List<Genre> list = new ArrayList<>();
        for(int i = 1; i<= count; i++){
            list.add(prepareGenre(i));
        }
        return list;
    }

    private AuthorName prepareAuthorName(int i) {
        AuthorName authorName = new AuthorName();
        authorName.setFirstName("Firstname" + i);
        authorName.setLastName("Lastname" + i);
        authorName.setSurName("Surname" + i);
        return authorName;
    }

}