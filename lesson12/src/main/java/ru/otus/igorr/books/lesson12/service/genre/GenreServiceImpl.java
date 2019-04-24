package ru.otus.igorr.books.lesson12.service.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson12.domain.genre.Genre;
import ru.otus.igorr.books.lesson12.dto.DtoConverter;
import ru.otus.igorr.books.lesson12.dto.GenreDto;
import ru.otus.igorr.books.lesson12.dto.GenreDtoConverter;
import ru.otus.igorr.books.lesson12.repository.genre.GenreRepository;

import java.util.List;


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
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(GenreDto dto) {
        repository.delete(converter.fill(dto));
    }


    @Override
    public List<GenreDto> getList() {
        return converter.convertList(repository.findAll());
    }

    @Override
    public List<GenreDto> getListByName(String mask) {
        List<Genre> genreList = repository.findByNameLike(mask);
        return converter.convertList(genreList);
    }
}
