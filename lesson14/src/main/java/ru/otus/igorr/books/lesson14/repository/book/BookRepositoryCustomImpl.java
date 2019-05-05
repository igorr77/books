package ru.otus.igorr.books.lesson14.repository.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ru.otus.igorr.books.lesson14.domain.book.Book;

import java.util.List;

public class BookRepositoryCustomImpl implements BookRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public BookRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Book> findByAuthorId(String authorId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("authors.$id").is(authorId));
        return mongoTemplate.find(query, Book.class);
    }

    @Override
    public List<Book> findByGenreId(String genreId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("genre.id").is(genreId));
        return mongoTemplate.find(query, Book.class);
    }

    @Override
    public boolean existsAuthor(String authorId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("authors.$id").is(authorId));
        return mongoTemplate.exists(query, Book.class);
    }
}
