package ru.otus.igorr.books.lesson15.service.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson15.dto.AuthorDto;
import ru.otus.igorr.books.lesson15.dto.BookDto;
import ru.otus.igorr.books.lesson15.dto.GenreDto;
import ru.otus.igorr.books.lesson15.dto.NoteDto;
import ru.otus.igorr.books.lesson15.utils.PrepareDataHelper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceImplTest {

    @Autowired
    BookService bookService;

    @Test
    void getByIdTest() {
        BookDto dto = bookService.get("BID001");
        assertEquals("BID001", dto.getId());
    }

    @Test
    void addTest() {
        BookDto book = new BookDto();

        List<GenreDto> genreList = new ArrayList<>();
        GenreDto genre = new GenreDto();
        genreList.add(genre);
        genre.setId("1");

        List<AuthorDto> authorList = new ArrayList<>();
        AuthorDto author = new AuthorDto();
        authorList.add(author);
        author.setId("A1");
        author.setGenreList(genreList);


        book.setTitle("Book.Title: test service add");
        book.setAuthorList(authorList);
        book.setGenre(genre);
        book.setDescription("Book.Description: test service add");

        String id = bookService.add(book);

        BookDto saveBook = bookService.get(id);

        assertAll(
                () -> assertNotNull(saveBook),
                () -> assertEquals(id, saveBook.getId())
        );

    }

    @Test
    void getList() {
    }

    @Test
    void addNoteTest() {

        NoteDto noteDto = PrepareDataHelper.prepareNoteDto("0");
        noteDto.setBookId("2L");

        NoteDto saveNoteDto = bookService.addNote(noteDto);


        List<BookDto> bookDto = bookService.getList();


        int breakPoint = 0;
    }


}