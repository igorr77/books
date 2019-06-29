package ru.otus.igorr.books.lesson23.repository.genre;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ru.otus.igorr.books.lesson23.domain.genre.Genre;

import java.util.List;

@RequiredArgsConstructor
public class GenreRepositoryCustomImpl implements GenreRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<Genre> findByNameLike(String regex) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(regex));
        return mongoTemplate.find(query, Genre.class);
    }
}
