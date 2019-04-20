package ru.otus.igorr.books.lesson10.service.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson10.dto.AuthorDto;
import ru.otus.igorr.books.lesson10.dto.BookDto;
import ru.otus.igorr.books.lesson10.dto.GenreDto;
import ru.otus.igorr.books.lesson10.dto.NoteDto;
import ru.otus.igorr.books.lesson10.utils.PrepareDataHelper;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BookServiceImplTest {

    @Autowired
    BookService bookService;

    @Test
    void getByIdTest() {
        BookDto dto = bookService.getById(1L);
    }

    @Test
    void addTest() {
        BookDto book = new BookDto();

        List<GenreDto> genreList = new ArrayList<>();
        GenreDto genre = new GenreDto();
        genreList.add(genre);
        genre.setId(1L);

        List<AuthorDto> authorList = new ArrayList<>();
        AuthorDto author = new AuthorDto();
        authorList.add(author);
        author.setId(1L);


        book.setTitle("Book.Title: test service add");
        book.setAuthorList(authorList);
        book.setGenreDto(genre);
        book.setDescription("Book.Description: test service add");

        long id = bookService.add(book);

        BookDto saveBook = bookService.getById(id);

        int breakPoint = 0;
    }

    @Test
    void getList() {
    }

    @Test
    void addNoteTest() {

        NoteDto noteDto = PrepareDataHelper.prepareNoteDto(0);
        noteDto.setBookId(2L);

        NoteDto saveNoteDto = bookService.addNote(noteDto);


        List<BookDto> bookDto = bookService.getList();


        int breakPoint = 0;
    }


}