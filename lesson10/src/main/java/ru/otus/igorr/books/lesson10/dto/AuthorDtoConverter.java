package ru.otus.igorr.books.lesson10.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson10.domain.author.Author;
import ru.otus.igorr.books.lesson10.domain.author.AuthorName;

import java.util.ArrayList;
import java.util.List;

@Service("authorConverter")
public class AuthorDtoConverter implements DtoConverter<Author, AuthorDto> {

    private final static Logger LOG = LoggerFactory.getLogger(AuthorDtoConverter.class);
    private static final long EMPTY_ID = -1L;

    private final GenreDtoConverter genreConverter;

    @Autowired
    public AuthorDtoConverter(@Qualifier("genreConverter") DtoConverter converter) {
        this.genreConverter = (GenreDtoConverter) converter;
    }

    @Override
    public AuthorDto convert(Author author) {
        return entity2dto(author);
    }

    @Override
    public Author fill(AuthorDto dto) {
        return dto2entity(dto);
    }

    @Override
    public List<AuthorDto> convertList(List<Author> entityList) {
        List<AuthorDto> dtoList = new ArrayList<>();
        entityList.forEach(e -> dtoList.add(entity2dto(e)));
        return dtoList;
    }

    @Override
    public List<Author> fillList(List<AuthorDto> dtoList) {
        List<Author> entityList = new ArrayList<>();
        dtoList.forEach(dto -> entityList.add(dto2entity(dto)));
        return entityList;
    }


    private AuthorDto entity2dto(Author author) {
        AuthorDto dto = new AuthorDto();

        try {
            dto.setId(author.getId());
            dto.setFirstName(author.getName().getFirstName());
            dto.setLastName(author.getName().getLastName());
            dto.setSurName(author.getName().getSurName());
            dto.setGenreList(genreConverter.convertList(author.getGenre()));
        } catch (NullPointerException npe) {
            LOG.warn("!!!", npe);
            dto.setId(EMPTY_ID);
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
        author.setGenre(genreConverter.fillList(dto.getGenreList()));

        return author;
    }

}
