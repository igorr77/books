package ru.otus.igorr.books.lesson12.repository.genre;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson12.domain.genre.Genre;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {

    @Override
    Genre save(Genre s);

    @Override
    <S extends Genre> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    Optional<Genre> findById(Long id);

    @Override
    boolean existsById(Long id);

    @Override
    List<Genre> findAll();

    @Override
    List<Genre> findAllById(Iterable<Long> iterable);

    @Override
    long count();

    @Override
    void deleteById(Long id);

    @Override
    void delete(Genre genre);

    @Override
    void deleteAll(Iterable<? extends Genre> iterable);

    @Override
    void deleteAll();
}
