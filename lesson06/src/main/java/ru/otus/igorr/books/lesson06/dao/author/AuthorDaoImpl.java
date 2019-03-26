package ru.otus.igorr.books.lesson06.dao.author;

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
import ru.otus.igorr.books.lesson06.domain.Author;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    private static final Logger LOG = LoggerFactory.getLogger(AuthorDaoImpl.class);

    private final AuthorMapper authorMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Value("${author.get}")
    private String queryGet;

    @Value("${author.insert}")
    private String queryInsert;

    @Value("${author.update}")
    private String queryUpdate;

    @Value("${author.delete}")
    private String queryDelete;

    @Value("${author.list}")
    private String queryList;

    @Value("${author.max}")
    private String queryMax;

    @Autowired
    public AuthorDaoImpl(AuthorMapper authorMapper,
                         NamedParameterJdbcTemplate jdbcTemplate) {
        this.authorMapper = authorMapper;
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Optional<Author> get(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(
                            queryGet,
                            params,
                            authorMapper
                    ));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }

    }

    @Override
    public int save(Author author) {
        String query = queryInsert;
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("firstname", author.getFirstName().trim());
        params.addValue("surname", author.getSurName().trim());
        params.addValue("lastname", author.getLastName().trim());
        params.addValue("country", author.getCountry().trim());
        if (author.getId() > 0) {
            query = queryUpdate;
            params.addValue("id", author.getId());
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
    public int delete(Author author) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", author.getId());

        try {
            return jdbcTemplate.update(queryDelete, params);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return 0;
        }

    }

    @Override
    public List<Author> getList(String condition) {
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
