package ru.otus.igorr.books.lesson15.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.otus.igorr.books.lesson15.dto.AuthorDto;
import ru.otus.igorr.books.lesson15.dto.BookDto;
import ru.otus.igorr.books.lesson15.dto.GenreDto;
import ru.otus.igorr.books.lesson15.service.facade.ServicesFacade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServicesFacade services;

    @Test
    void authorPageTest() throws Exception {

        List<BookDto> books = new ArrayList();
        books.add(prepareBook(1));

        when(services.getBookList()).thenReturn(books);

        List<BookDto> list = (ArrayList<BookDto>)
        mockMvc.perform(MockMvcRequestBuilders
                .get("/book/list")
                .accept(MediaType.ALL))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getModelAndView()
                .getModel()
                .get("books");

        assertAll(
                () -> assertNotNull(list),
                () -> assertTrue(list.get(0).getTitle().contains("BookTitle")),
                () -> assertEquals(1, list.get(0).getAuthorList().size())
        );


        int breakPoint = 0;

    }

    private BookDto prepareBook(int n) {
        return new BookDto.Builder()
                .title("BookTitle_" + n)
                .genre(new GenreDto("Genre_" + n, "GenreDescription_" + n))
                .authorList(Arrays.asList(new AuthorDto("Firstname_" + n, "Lastname_" + n, "Surname_" + n
                        , Arrays.asList(new GenreDto("Genre_" + n, "GenreDescription_" + n)))))
                .description("BookDescription_" + n)
                .noteList(Collections.emptyList())
                .build();
    }
}