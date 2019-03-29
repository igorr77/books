package ru.otus.igorr.books.lesson06.services.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson06.dao.author.AuthorDao;
import ru.otus.igorr.books.lesson06.domain.Author;
import ru.otus.igorr.books.lesson06.exceptions.AuthorNotFoundException;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao dao;

    @Autowired
    public AuthorServiceImpl(AuthorDao dao) {
        this.dao = dao;
    }

    @Override
    public Author get(int id) {
        return dao.get(id).orElseThrow(() -> new AuthorNotFoundException(id));
    }

    @Override
    public int save(Author entity) {
        return dao.save(entity);
    }

    @Override
    public int delete(Author entity) {
        return dao.delete(entity);
    }

    @Override
    public List<Author> getList(String condition) {
        return dao.getList(condition);
    }

    public int getMaxId() {
        return dao.getMaxId();
    }
}
