package ru.otus.igorr.books.lesson06.dao.genre;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson06.domain.Genre;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class GenreDaoImpl implements GenreDao {

    private static final Logger LOG = LoggerFactory.getLogger(GenreDaoImpl.class);

    private final GenreMapper genreMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final Environment env;

    @Autowired
    public GenreDaoImpl(GenreMapper genreMapper,
                        NamedParameterJdbcTemplate jdbcTemplate,
                        Environment env) {
        this.genreMapper = genreMapper;
        this.jdbcTemplate = jdbcTemplate;
        this.env = env;
    }

    @Override
    public Optional<Genre> get(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(
                            env.getProperty("queries.genre.get"),
                            params,
                            genreMapper
                    ));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public int save(Genre entity) {
        String query = env.getProperty("queries.genre.insert");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", entity.getName().trim());
        params.addValue("desc", entity.getDescription().trim());
        if (entity.getId() > 0) {
            query = env.getProperty("queries.genre.update");
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
            return jdbcTemplate.update(env.getProperty("queries.genre.delete"), params);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return 0;
        }
    }

    @Override
    public List<Genre> getList(String condition) {
        MapSqlParameterSource params = new MapSqlParameterSource();

        try {
            List<Genre> list = jdbcTemplate.query(env.getProperty("queries.genre.list"), params, genreMapper);
            return list;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public int getMaxId() {
        MapSqlParameterSource params = new MapSqlParameterSource();
        try {
            return jdbcTemplate.queryForObject(env.getProperty("queries.genre.max"), params, Integer.class);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return 0;
        }
    }
}
