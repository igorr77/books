package ru.otus.igorr.books.lesson06.services.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.igorr.books.lesson06.dao.genre.GenreDao;
import ru.otus.igorr.books.lesson06.domain.Genre;
import ru.otus.igorr.books.lesson06.exceptions.GenreNotFoundException;

public class GenreServiceImpl implements GenreService {

    private GenreDao dao;

    @Autowired
    public GenreServiceImpl(GenreDao dao){
        this.dao = dao;
    }

    @Override
    public Genre getGenre(int id) {
        return dao.getById(id).orElseThrow(() -> new GenreNotFoundException(id));
    }
}
