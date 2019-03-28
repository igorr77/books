package ru.otus.igorr.books.lesson06.dao.author;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.otus.igorr.books.lesson06.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Component
public class AuthorMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setId(rs.getInt("id"));
        author.setFirstName(Optional.ofNullable(rs.getString("firstname")).orElse("").trim());
        author.setSurName(Optional.ofNullable(rs.getString("surname")).orElse("").trim());
        author.setLastName(Optional.ofNullable(rs.getString("lastname")).orElse("").trim());
        author.setCountry(Optional.ofNullable(rs.getString("country")).orElse("").trim());
        return author;
    }
}
