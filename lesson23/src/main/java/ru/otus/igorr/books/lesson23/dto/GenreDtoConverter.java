package ru.otus.igorr.books.lesson23.dto;

import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson23.domain.genre.Genre;

import java.util.ArrayList;
import java.util.List;

@Service("genreConverter")
public class GenreDtoConverter implements DtoConverter<Genre, GenreDto> {

    @Override
    public GenreDto convert(Genre genre) {
        return entity2dto(genre);
    }

    @Override
    public Genre fill(GenreDto dto) {
        return dto2entity(dto);
    }

    private GenreDto entity2dto(Genre genre) {
        GenreDto dto = new GenreDto();
        dto.setId(genre.getId());
        dto.setName(genre.getName());
        dto.setDescription(genre.getDescription());
        return dto;
    }

    private Genre dto2entity(GenreDto dto) {
        Genre genre = new Genre();
        genre.setId(dto.getId());
        genre.setName(dto.getName());
        genre.setDescription(dto.getDescription());
        return genre;
    }
}
