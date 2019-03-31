package ru.otus.igorr.books.lesson08.repository.genre;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.igorr.books.lesson08.domain.genre.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
@Transactional
public class GenreRepositoryImpl implements GenreRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Genre getById(int id) {
        return em.find(Genre.class, id);
    }

    @Override
    public int save(Genre genre) {
        if (genre.getId() == 0) {
            em.persist(genre);
        } else {
            em.merge(genre);
        }
        return 0;
    }
}
