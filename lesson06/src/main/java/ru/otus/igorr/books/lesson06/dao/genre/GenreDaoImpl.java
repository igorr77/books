package ru.otus.igorr.books.lesson06.dao.genre;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson06.domain.Genre;

import java.util.List;
import java.util.Optional;

@Repository
public class GenreDaoImpl implements GenreDao {

    private static final Logger LOG = LoggerFactory.getLogger(GenreDaoImpl.class);

    private final GenreMapper genreMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Value("${genre.get}")
    private String queryGet;

    @Value("${genre.insert}")
    private String queryInsert;

    @Value("${genre.update}")
    private String queryUpdate;

    @Value("${genre.delete}")
    private String queryDelete;

    @Value("${genre.max}")
    private String queryMax;

    @Autowired
    public GenreDaoImpl(GenreMapper genreMapper,
                        NamedParameterJdbcTemplate jdbcTemplate) {
        this.genreMapper = genreMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Genre> get(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(
                            queryGet,
                            params,
                            genreMapper
                    ));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public int save(Genre entity) {
        String query = queryInsert;
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("genre", entity.getGenre().trim());
        params.addValue("desc", entity.getDescription().trim());
        if (entity.getId() > 0) {
            query = queryUpdate;
            params.addValue("id", entity.getId());
        }

        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(query, params, keyHolder);
            return (Integer) keyHolder.getKeys().get("id");
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return 0;
        }
    }


    @Override
    public int delete(Genre entity) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", entity.getId());

        try {
            return jdbcTemplate.update(queryDelete, params);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return 0;
        }
    }

    @Override
    public List<Genre> getList(String condition) {
        return null;
    }

    @Override
    public int max() {
        MapSqlParameterSource params = new MapSqlParameterSource();
        try {
            int r = jdbcTemplate.queryForObject(queryMax, params, Integer.class);
            return r;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return 0;
        }

    }
}
