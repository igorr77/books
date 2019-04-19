package ru.otus.igorr.books.lesson12.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.igorr.books.lesson12.domain.author.Author;
import ru.otus.igorr.books.lesson12.domain.author.AuthorName;
import ru.otus.igorr.books.lesson12.domain.genre.Genre;
import ru.otus.igorr.books.lesson12.dto.AuthorDto;
import ru.otus.igorr.books.lesson12.dto.DtoConverter;
import ru.otus.igorr.books.lesson12.dto.GenreDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration
//@ContextConfiguration(classes = {AuthorDtoConverter.class})
@ComponentScan(basePackages = {"ru.otus.igorr.books.lesson10"})
class AuthorDtoConverterTest {

    private final String ENTITY_2_DTO_OBJECT_ID = "1L";
    private final String ENTITY_2_DTO_SUBOBJECT_ID = "11L";
    private final String DTO_2_ENTITY_OBJECT_ID = "2L";
    private final String DTO_2_ENTITY_SUBOBJECT_ID = "21L";

    @Autowired
    @Qualifier("authorConverter")
    private DtoConverter converter;

    @Test
    void convertTest() {

        Author author = prepareAuthor();

        AuthorDto dto = (AuthorDto) converter.convert(author);

        assertAll(
                () -> assertEquals(ENTITY_2_DTO_OBJECT_ID, dto.getId()),
                () -> assertTrue(author.getName().getFirstName().equals(dto.getFirstName())),
                () -> assertNotNull(dto.getGenreList()),
                () -> assertEquals(ENTITY_2_DTO_SUBOBJECT_ID, dto.getGenreList().get(0).getId())
        );
    }

    @Test
    void fillTest() {
        AuthorDto dto = prepareDto();
        Author author = (Author) converter.fill(dto);

        assertAll(
                () -> assertEquals(DTO_2_ENTITY_OBJECT_ID, author.getId()),
                () -> assertEquals(DTO_2_ENTITY_SUBOBJECT_ID, author.getGenres().get(0).getId())
        );
    }

    private Author prepareAuthor() {
        AuthorName authorName = new AuthorName();
        authorName.setFirstName("First Name");
        authorName.setLastName("Last Name");
        authorName.setSurName("Sur Name");

        Genre genre = new Genre();
        genre.setId(ENTITY_2_DTO_SUBOBJECT_ID);
        genre.setName("Genre Name");
        genre.setDescription("Genre Description");
        List<Genre> genreList = new ArrayList<>();
        genreList.add(genre);

        Author author = new Author();
        author.setId(ENTITY_2_DTO_OBJECT_ID);
        author.setName(authorName);
        author.setGenres(genreList);
        return author;
    }

    private AuthorDto prepareDto() {

        List<GenreDto> genreDtoList = new ArrayList<>();
        GenreDto genreDto = new GenreDto();
        genreDtoList.add(genreDto);
        genreDto.setId(DTO_2_ENTITY_SUBOBJECT_ID);
        genreDto.setName("Dto Genre Name");
        genreDto.setDescription("Dto Genre Description");

        AuthorDto dto = new AuthorDto();
        dto.setId(DTO_2_ENTITY_OBJECT_ID);
        dto.setFirstName("DtoFirstName");
        dto.setLastName("DtoLastName");
        dto.setSurName("DtoSurName");
        dto.setGenreList(genreDtoList);
        return dto;
    }


}