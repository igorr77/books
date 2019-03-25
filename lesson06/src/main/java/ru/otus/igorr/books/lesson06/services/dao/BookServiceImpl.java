package ru.otus.igorr.books.lesson06.services.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson06.dao.books.BookDao;
import ru.otus.igorr.books.lesson06.domain.Book;
import ru.otus.igorr.books.lesson06.exceptions.BookNotFoundException;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    private final BookDao dao;

    @Autowired
    public BookServiceImpl(BookDao dao) {
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

    @Override
    public int max() {
        return dao.max();
    }
}
