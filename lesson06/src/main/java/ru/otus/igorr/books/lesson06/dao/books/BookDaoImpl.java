package ru.otus.igorr.books.lesson06.dao.books;

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
import ru.otus.igorr.books.lesson06.domain.Book;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class BookDaoImpl implements BookDao {

    private static final Logger LOG = LoggerFactory.getLogger(BookDaoImpl.class);

    private final BookMapper bookMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final Environment env;

    @Autowired
    public BookDaoImpl(BookMapper bookMapper,
                       NamedParameterJdbcTemplate jdbcTemplate,
                       Environment env) {
        this.bookMapper = bookMapper;
        this.jdbcTemplate = jdbcTemplate;
        this.env = env;
    }

    @Override
    public Optional<Book> get(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(
                            env.getProperty("queries.books.get"),
                            params,
                            bookMapper
                    ));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }


    @Override
    public int save(Book book) {
        String query = env.getProperty("queries.books.insert");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("author_id", book.getAuthorId());
        params.addValue("genre_id", book.getGenreId());
        params.addValue("title", book.getTitle().trim());
        params.addValue("isbn", book.getIsbn().trim());
        params.addValue("pages", book.getPages());
        params.addValue("description", book.getDescription().trim());
        if (book.getId() > 0) {
            query = env.getProperty("queries.books.update");
            params.addValue("id", book.getId());
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
    public int delete(Book entity) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", entity.getId());

        try {
            return jdbcTemplate.update(env.getProperty("queries.books.delete"), params);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return 0;
        }
    }

    @Override
    public List<Book> getList(String condition) {
        MapSqlParameterSource params = new MapSqlParameterSource();

        try {
            List<Book> bookList = jdbcTemplate.query(env.getProperty("queries.books.list"), params, bookMapper);
            return bookList;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public int getMaxId() {
        MapSqlParameterSource params = new MapSqlParameterSource();
        try {
            return jdbcTemplate.queryForObject(env.getProperty("queries.books.max"), params, Integer.class);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return 0;
        }
    }
}
