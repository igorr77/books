package ru.otus.igorr.books.lesson10.service.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson10.domain.genre.Genre;
import ru.otus.igorr.books.lesson10.dto.DtoConverter;
import ru.otus.igorr.books.lesson10.dto.GenreDto;
import ru.otus.igorr.books.lesson10.dto.GenreDtoConverter;
import ru.otus.igorr.books.lesson10.repository.genre.GenreRepository;

import java.util.ArrayList;
import java.util.List;

import static ru.otus.igorr.books.lesson10.utils.Constant.NOT_FOUND_ENTITY_ID;


@Service
public class GenreServiceImpl implements GenreService {

    private static final Genre EMPTY_GENRE = new Genre();
    private final GenreRepository repository;
    private final DtoConverter<Genre, GenreDto> converter;

    @Autowired
    public GenreServiceImpl(GenreRepository repository,
                            @Qualifier("genreConverter") DtoConverter converter) {
        this.repository = repository;
        this.converter = converter;

        EMPTY_GENRE.setId(NOT_FOUND_ENTITY_ID);
    }


    @Override
    public GenreDto getById(long id) {
        return converter.convert(repository.findById(id).orElse(EMPTY_GENRE));
    }

    @Override
    public void add(GenreDto dto) {
        Genre genre = repository.save(converter.fill(dto));
        int breakPoint = 0;
    }

    @Override
    public List<GenreDto> getList() {

        List<Genre> genreList = repository.findAll();

        List<GenreDto> dtoList = new ArrayList<>();
        genreList.forEach(e -> dtoList.add(((GenreDtoConverter) converter).convert(e)));

        return dtoList;
    }

}
