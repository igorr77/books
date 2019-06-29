package ru.otus.igorr.books.lesson23.repository.genre;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson23.domain.genre.Genre;

import java.util.List;

@Repository
public interface GenreH2Repository extends CrudRepository<Genre, Long> {

    @Override
    List<Genre> findAll();
}
