package ru.otus.igorr.books.lesson14.repository.author;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ru.otus.igorr.books.lesson14.domain.author.Author;

import java.util.List;

@RequiredArgsConstructor
public class AuthorRepositoryCustomImpl implements AuthorRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<Author> findByNameLike(String regex) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name.firstName").regex(regex));
        return mongoTemplate.find(query, Author.class);
    }

    @Override
    public List<Author> findByGenreId(String genreId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("genre.$id").is(genreId));
        return mongoTemplate.find(query, Author.class);
    }
}
