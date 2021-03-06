package ru.otus.igorr.books.lesson06.dao.books;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.otus.igorr.books.lesson06.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;


@Component
public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int i) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setAuthorId(rs.getInt("authorid"));
        book.setAuthorName(rs.getString("authorname"));
        book.setGenreId(rs.getInt("genreid"));
        book.setGenreName(rs.getString("genreName"));
        book.setIsbn(rs.getString("isbn"));
        book.setPages(rs.getInt("pages"));
        book.setDescription(Optional.ofNullable(rs.getString("description")).orElse("").trim());
        return book;
    }
}
