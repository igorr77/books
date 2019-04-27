package ru.otus.igorr.books.lesson06.services.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson06.dao.author.AuthorDao;
import ru.otus.igorr.books.lesson06.dao.books.BookDao;
import ru.otus.igorr.books.lesson06.dao.genre.GenreDao;
import ru.otus.igorr.books.lesson06.domain.Author;
import ru.otus.igorr.books.lesson06.domain.Book;
import ru.otus.igorr.books.lesson06.domain.Genre;
import ru.otus.igorr.books.lesson06.exceptions.AuthorNotFoundException;
import ru.otus.igorr.books.lesson06.exceptions.BookNotFoundException;
import ru.otus.igorr.books.lesson06.exceptions.GenreNotFoundException;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    Logger LOG = LoggerFactory.getLogger(BookServiceImpl.class);

    private final AuthorDao authorDao;
    private final GenreDao genreDao;
    private final BookDao bookDao;

    @Autowired
    public BookServiceImpl(AuthorDao authorDao, GenreDao genreDao, BookDao bookDao) {
        this.authorDao = authorDao;
        this.genreDao = genreDao;
        this.bookDao = bookDao;
    }

    @Override
    public Book get(int id) {
        return bookDao.get(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public int save(Book book) {
        Author author = authorDao.get(book.getAuthorId()).orElseThrow(() -> new AuthorNotFoundException(book.getAuthorId()));
        Genre genre = genreDao.get(book.getGenreId()).orElseThrow(() -> new GenreNotFoundException(book.getGenreId()));
        LOG.debug(book.toString());
        return bookDao.save(book);
    }

    @Override
    public int delete(Book book) {
        return bookDao.delete(book);
    }

    @Override
    public List<Book> getList(String condition) {
        return bookDao.getList(condition);
    }

    @Override
    public int getMaxId() {
        return bookDao.getMaxId();
    }
}
