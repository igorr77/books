package ru.otus.igorr.books.lesson06.services.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.igorr.books.lesson06.dao.books.BooksDao;
import ru.otus.igorr.books.lesson06.domain.Book;
import ru.otus.igorr.books.lesson06.exceptions.BookNotFoundException;

import java.util.List;

public class BooksServiceImpl implements BooksService {

    private BooksDao dao;

    @Autowired
    public BooksServiceImpl(BooksDao dao) {
        this.dao = dao;
    }

    @Override
    public Book get(int id) {
        return dao.get(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public int save(Book entity) {
        return dao.save(entity);
    }

    @Override
    public int delete(Book entity) {
        return dao.delete(entity);
    }

    @Override
    public List<Book> getList(String condition) {
        return dao.getList(condition);
    }
}
