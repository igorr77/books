package ru.otus.igorr.books.lesson25.repository.mongo.genre;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson25.domain.mongo.genre.Genre;

@Repository
public interface GenreRepository extends MongoRepository<Genre, String>, GenreRepositoryCustom {
}
