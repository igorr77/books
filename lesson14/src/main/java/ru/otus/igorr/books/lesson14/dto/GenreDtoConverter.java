package ru.otus.igorr.books.lesson14.dto;

import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson14.domain.genre.Genre;

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

    @Override
    public List<GenreDto> convertList(final List<Genre> list) {
        final List<GenreDto> genreDtoList = new ArrayList<>();
        list.forEach(genre -> genreDtoList.add(entity2dto(genre)));
        return genreDtoList;
    }

    @Override
    public List<Genre> fillList(final List<GenreDto> list) {
        final List<Genre> genreList = new ArrayList<>();
        list.forEach(dto -> genreList.add(dto2entity(dto)));
        return genreList;
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
