package ru.otus.igorr.books.lesson06.dao.books;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson06.domain.Book;

import java.util.List;
import java.util.Optional;

@Repository
public class BookDaoImpl implements BookDao {

    private static final Logger LOG = LoggerFactory.getLogger(BookDaoImpl.class);

    private final BookMapper bookMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Value("${books.get}")
    private String queryGet;

    @Value("${books.insert}")
    private String queryInsert;

    @Value("${books.update}")
    private String queryUpdate;

    @Value("${books.delete}")
    private String queryDelete;

    @Value("${books.max}")
    private String queryMax;

    @Autowired
    public BookDaoImpl(BookMapper bookMapper,
                       NamedParameterJdbcTemplate jdbcTemplate) {
        this.bookMapper = bookMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Book> get(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(
                            queryGet,
                            params,
                            bookMapper
                    ));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }


    @Override
    public int save(Book entity) {
        return 0;
    }

    @Override
    public int delete(Book entity) {
        return 0;
    }

    @Override
    public List<Book> getList(String condition) {
        return null;
    }

    @Override
    public int max() {
        return 0;
    }
}
