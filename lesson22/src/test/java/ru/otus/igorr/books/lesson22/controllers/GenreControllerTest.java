package ru.otus.igorr.books.lesson22.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class GenreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @WithMockUser(
            username = "user",
            authorities = {"ROLE_EDIT"}
    )
    @Test
    void listPageSuccessfulTest() throws Exception {
        mockMvc.perform(get("/genre/add"))
                .andExpect(status().isOk());
    }

    @WithMockUser(
            username = "user",
            authorities = {"ROLE_VIEW"}
    )
    @Test
    void listPageFailTest() throws Exception {
        mockMvc.perform(get("/genre/add"))
                .andExpect(status().is4xxClientError());
    }


}


