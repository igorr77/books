package ru.otus.igorr.books.lesson06.dao.author;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.otus.igorr.books.lesson06.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AuthorMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setId(rs.getInt("id"));
        author.setFirstName(rs.getString("firstname"));
        author.setSurName(rs.getString("surname"));
        author.setLastName(rs.getString("lastname"));
        author.setCountry(rs.getString("country"));
        return author;
    }
}
