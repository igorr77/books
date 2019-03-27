package ru.otus.igorr.books.lesson06.services.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson06.dao.genre.GenreDao;
import ru.otus.igorr.books.lesson06.domain.Genre;
import ru.otus.igorr.books.lesson06.exceptions.GenreNotFoundException;

import java.util.List;


@Service
public class GenreServiceImpl implements GenreService {

    private final GenreDao dao;

    @Autowired
    public GenreServiceImpl(GenreDao dao) {
        this.dao = dao;
    }

    @Override
    public Genre get(int id) {
        return dao.get(id).orElseThrow(() -> new GenreNotFoundException(id));
    }

    @Override
    public int save(Genre genre) {
        return dao.save(genre);
    }

    @Override
    public int delete(Genre genre) {
        return dao.delete(genre);
    }

    @Override
    public List<Genre> getList(String condition) {
        return dao.getList(condition);
    }

    @Override
    public int getMaxId() {
        return dao.getMaxId();
    }
}
