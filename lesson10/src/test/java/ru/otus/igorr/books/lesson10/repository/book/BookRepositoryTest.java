package ru.otus.igorr.books.lesson10.repository.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ru.otus.igorr.books.lesson10.domain.book.Book;
import ru.otus.igorr.books.lesson10.domain.book.Note;
import ru.otus.igorr.books.lesson10.utils.PrepareDataHelper;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.otus.igorr.books.lesson10.utils.Constant.NOT_FOUND_ENTITY_ID;

@DataJpaTest
class BookRepositoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(BookRepositoryTest.class);

    private static final Book EMPTY_BOOK = new Book();
    private static final long FIND_ID = 1L;
    private static final long DELETE_ID = 999L;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    NoteRepository noteRepository;


    @BeforeEach
    void setUp() {
        EMPTY_BOOK.setId(NOT_FOUND_ENTITY_ID);
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
                () -> assertEquals(NOT_FOUND_ENTITY_ID, deletedBook.getId())
        );

    }

    @Test
    void findAllTest() {
        Page<Book> page = bookRepository.findAll(PageRequest.of(1, 2, new Sort(Sort.Direction.ASC, "id")));
        assertEquals(4L, page.getContent().get(1).getId());
    }

    @Test
    void addNoteTest() {
        Book book = PrepareDataHelper.prepareBook();

        Book saveBook = bookRepository.saveAndFlush(book);

        Page<Book> bookPage = bookRepository.findAll(PageRequest.of(0, 20, new Sort(Sort.Direction.ASC, "id")));


        Note note = PrepareDataHelper.prepareNote(0);
        note.setBook(saveBook);

        LOG.debug("-------- add Note -------------");

        noteRepository.saveAndFlush(note);

        LOG.debug("--------- flush ------------");

        bookRepository.flush();

        LOG.debug("--------- find book ------------");

        //List<Note> noteList = new ArrayList<>();
        //noteList.add(note);
        //saveBook.setNoteList(noteList);

        Book qqq = bookRepository.findById(saveBook.getId()).orElse(new Book());


        LOG.debug("-------- notePage -------------");

        Page<Note> notePage = noteRepository.findAll(PageRequest.of(0, 20, new Sort(Sort.Direction.ASC, "noteId")));


        LOG.debug("---------- book Page -----------");

        bookPage = bookRepository.findAll(PageRequest.of(0, 20, new Sort(Sort.Direction.ASC, "id")));

        int breakPoint = 1;
    }


}