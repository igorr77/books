package ru.otus.igorr.books.lesson20.dto;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson20.domain.author.Author;
import ru.otus.igorr.books.lesson20.domain.author.AuthorName;
import ru.otus.igorr.books.lesson20.domain.book.Book;
import ru.otus.igorr.books.lesson20.domain.genre.Genre;
import ru.otus.igorr.books.lesson20.utils.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("authorConverter")
@RequiredArgsConstructor
public class AuthorDtoConverter implements DtoConverter<Author, AuthorDto> {

    private final static Logger LOG = LoggerFactory.getLogger(AuthorDtoConverter.class);

    private final DtoConverter<Genre, GenreDto> genreConverter;
    private final DtoConverter<Book, BookDto> bookConverter;

    @Override
    public AuthorDto convert(Author author) {
        return entity2dto(author);
    }

    @Override
    public Author fill(AuthorDto dto) {
        return dto2entity(dto);
    }

    private AuthorDto entity2dto(Author author) {
        AuthorDto dto = new AuthorDto();

        try {
            dto.setId(author.getId());
            dto.setFirstName(author.getName().getFirstName());
            dto.setLastName(author.getName().getLastName());
            dto.setSurName(author.getName().getSurName());
            dto.setGenreList(author.getGenres().stream()
                    .map(genre -> genreConverter.convert(genre))
                    .collect(Collectors.toList()));
            List<Book> bookList = new ArrayList<>();
            dto.setBookList(bookList.stream()
                    .map(book -> bookConverter.convert(book))
                    .collect(Collectors.toList())
            );
        } catch (NullPointerException npe) {
            LOG.warn("!!!", npe);
            dto.setId(Constant.NOT_FOUND_DOCUMENT_ID);
        }
        return dto;

    }

    private Author dto2entity(AuthorDto dto) {
        Author author = new Author();
        AuthorName authorName = new AuthorName();

        authorName.setFirstName(dto.getFirstName());
        authorName.setLastName(dto.getLastName());
        authorName.setSurName(dto.getSurName());

        author.setId(dto.getId());
        author.setName(authorName);
        author.setGenres(
                Optional.ofNullable(dto.getGenreList()).orElse(Collections.emptyList())
                        .stream()
                        .map(genreDto -> genreConverter.fill(genreDto))
                        .collect(Collectors.toList())

        );

        return author;
    }

}
