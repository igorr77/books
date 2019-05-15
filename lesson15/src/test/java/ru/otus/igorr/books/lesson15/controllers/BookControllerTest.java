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

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
        books.add(prepareBook(2));

        when(services.getBookList()).thenReturn(books);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/book/list")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].title", is("BookTitle_1")))
                .andExpect(jsonPath("$[1].title", is("BookTitle_2")));

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