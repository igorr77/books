package ru.otus.igorr.books.lesson10.service.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson10.dto.BookDto;
import ru.otus.igorr.books.lesson10.dto.NoteDto;
import ru.otus.igorr.books.lesson10.utils.PrepareDataHelper;

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
    void add() {
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