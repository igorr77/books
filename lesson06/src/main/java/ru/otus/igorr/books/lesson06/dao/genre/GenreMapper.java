package ru.otus.igorr.books.lesson06.dao.genre;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.otus.igorr.books.lesson06.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Component
public class GenreMapper implements RowMapper<Genre> {

    @Override
    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
        Genre genre = new Genre();
        genre.setId(rs.getInt("id"));
        genre.setName(Optional.ofNullable(rs.getString("name")).orElse("").trim());
        genre.setDescription(Optional.ofNullable(rs.getString("description")).orElse("").trim());
        return genre;
    }

}

