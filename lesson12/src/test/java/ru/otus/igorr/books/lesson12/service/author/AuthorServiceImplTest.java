package ru.otus.igorr.books.lesson12.service.author;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.igorr.books.lesson12.domain.author.Author;
import ru.otus.igorr.books.lesson12.domain.genre.Genre;
import ru.otus.igorr.books.lesson12.dto.AuthorDto;
import ru.otus.igorr.books.lesson12.dto.BookDto;
import ru.otus.igorr.books.lesson12.dto.GenreDto;
import ru.otus.igorr.books.lesson12.service.author.AuthorService;
import ru.otus.igorr.books.lesson12.service.genre.GenreService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static ru.otus.igorr.books.lesson12.utils.Constant.NOT_FOUND_DOCUMENT_ID;

@SpringBootTest
class AuthorServiceImplTest {

    @Autowired
    AuthorService authorService;

    @Autowired
    GenreService genreService;

    @Test
    void addTest() {
        AuthorDto authorForSave = prepareAuthor();

        //authorForSave.getGenreList().forEach( genreDto -> genreService.add(genreDto));

        String saveId = authorService.add(authorForSave);

        AuthorDto author = authorService.getById(saveId);

        int breakPoint = 0;
    }

    @ParameterizedTest
    @ValueSource(strings = {"A1", "A2"})
    void getByIdTest(String param) {
        AuthorDto dto = authorService.getById(param);
        assertEquals(param, dto.getId());
    }

    @ParameterizedTest
    @ValueSource(strings = {"A3"})
    void getByIdNotFoundTest(String param) {
        AuthorDto dto = authorService.getById(param);
        assertEquals(NOT_FOUND_DOCUMENT_ID, dto.getId());
    }


    private AuthorDto prepareAuthor() {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setFirstName("FirstNameFromDto");
        authorDto.setLastName("LastNameFromDto");
        authorDto.setSurName("SurNameFromDto");
        authorDto.setGenreList(prepareGenreList(2));
        authorDto.setBookList(prepareBookList(3));
        return authorDto;
    }

    private List<GenreDto> prepareGenreList(final int n) {
        return IntStream.range(0, n)
                .mapToObj(i -> prepareGenre(i))
                .collect(Collectors.toList());
    }

    private GenreDto prepareGenre(int i) {
        return new GenreDto("ID.GENRE" + i, "Genre.Name" + i, "Genre.Description" + i);
    }

    private List<BookDto> prepareBookList(int n) {
        return IntStream.range(0, n)
                .mapToObj(i -> prepareBook(i))
                .collect(Collectors.toList());
    }

    private BookDto prepareBook(int i) {
        BookDto dto = new BookDto();
        dto.setId("BOOKID" + i);
        dto.setTitle("Title");
        dto.setGenreDto(prepareGenre(i));
        dto.setDescription("Book.Description" + i);
        return dto;
    }

}