package ru.otus.igorr.books.lesson12.service.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson12.domain.genre.Genre;
import ru.otus.igorr.books.lesson12.dto.DtoConverter;
import ru.otus.igorr.books.lesson12.dto.GenreDto;
import ru.otus.igorr.books.lesson12.dto.GenreDtoConverter;
import ru.otus.igorr.books.lesson12.repository.genre.GenreRepository;

import java.util.ArrayList;
import java.util.List;

import static ru.otus.igorr.books.lesson12.utils.Constant.NOT_FOUND_ENTITY_ID;


@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository repository;
    private final DtoConverter<Genre, GenreDto> converter;

    @Autowired
    public GenreServiceImpl(GenreRepository repository,
                            @Qualifier("genreConverter") DtoConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }


    @Override
    public GenreDto getById(String id) {
        return converter.convert(repository.findById(id).orElse(Genre.empty()));
    }

    @Override
    public String add(GenreDto dto) {
        Genre genre = repository.save(converter.fill(dto));
        return genre.getId();
    }

    @Override
    public List<GenreDto> getList() {

        List<Genre> genreList = repository.findAll();

        List<GenreDto> dtoList = new ArrayList<>();
        genreList.forEach(e -> dtoList.add(((GenreDtoConverter) converter).convert(e)));

        return dtoList;
    }

    @Override
    public List<GenreDto> getListByName(String mask) {
        return null;
    }
}
