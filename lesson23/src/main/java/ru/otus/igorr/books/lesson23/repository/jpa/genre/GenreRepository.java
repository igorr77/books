package ru.otus.igorr.books.lesson23.repository.jpa.genre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson23.domain.jpa.genre.Genre;

import java.util.List;
import java.util.Optional;

@Repository("jenreJpaRepository")
public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Override
    Genre save(Genre s);

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
