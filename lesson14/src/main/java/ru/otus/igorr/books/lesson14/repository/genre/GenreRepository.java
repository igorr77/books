package ru.otus.igorr.books.lesson14.repository.genre;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson14.domain.genre.Genre;

@Repository
public interface GenreRepository extends MongoRepository<Genre, String>, GenreRepositoryCustom {
}
