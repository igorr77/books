package ru.otus.igorr.books.lesson06.dao.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson06.domain.Genre;
import ru.otus.igorr.books.lesson06.exceptions.GenreNotFoundException;

import java.util.List;
import java.util.Optional;

@Repository
public class GenreDaoImpl implements GenreDao {

    private final GenreMapper genreMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public GenreDaoImpl(GenreMapper genreMapper, NamedParameterJdbcTemplate jdbcTemplate) {
        this.genreMapper = genreMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Genre> getById(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(
                    "select id, genre, description from books.genre_data where id = :id",
                    params,
                    genreMapper
            ));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }


    }

    @Override
    public void insert(Genre genre) {

    }

    @Override
    public void update(Genre genre) {

    }


}
