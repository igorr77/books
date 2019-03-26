package ru.otus.igorr.books.lesson06.dao.books;

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
import ru.otus.igorr.books.lesson06.domain.Book;

import java.util.*;

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

    @Value("${books.list}")
    private String queryList;

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
    public int save(Book book) {
        String query = queryInsert;
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("author_id", book.getAuthorId());
        params.addValue("genre_id", book.getGenreId());
        params.addValue("title", book.getTitle().trim());
        params.addValue("isbn", book.getIsbn().trim());
        params.addValue("pages", book.getPages());
        params.addValue("description", book.getDescription().trim());
        if (book.getId() > 0) {
            query = queryUpdate;
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
            return jdbcTemplate.update(queryDelete, params);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return 0;
        }
    }

    @Override
    public List<Book> getList(String condition) {
        List<Book> listBook = new ArrayList<>();

        MapSqlParameterSource params = new MapSqlParameterSource();

        try {
            List<Map<String, Object>> mapList = jdbcTemplate.queryForList(queryList, params);
            mapList.forEach(m -> {
                Book book = new Book();
                book.setId((int) m.get("id"));
                book.setAuthorId((int) m.get("id"));
                book.setAuthorName(((String) m.get("authorname")).trim());
                book.setGenreId((int) m.get("id"));
                book.setGenre(((String) m.get("genre")).trim());
                book.setTitle(((String) m.get("title")).trim());
                book.setPages((int) m.get("pages"));
                book.setIsbn(((String) m.get("isbn")).trim());
                book.setDescription(((String) m.get("description")).trim());
                listBook.add(book);
            });

            return listBook;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return Collections.emptyList();
        }


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
