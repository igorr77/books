package ru.otus.igorr.books.lesson06.dao.genre;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.otus.igorr.books.lesson06.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GenreMapper implements RowMapper<Genre> {

    @Override
    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
        Genre genre = new Genre();
        genre.setId(rs.getInt("id"));
        genre.setGenre(rs.getString("genre"));
        genre.setDescription(rs.getString("description"));
        return genre;
    }

}

