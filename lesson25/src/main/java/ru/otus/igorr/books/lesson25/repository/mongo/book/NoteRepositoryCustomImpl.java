package ru.otus.igorr.books.lesson25.repository.mongo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ru.otus.igorr.books.lesson25.domain.mongo.book.Note;

import java.util.List;

public class NoteRepositoryCustomImpl implements NoteRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public NoteRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public List<Note> findByBookId(String bookId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("book.$id").is(bookId));
        return mongoTemplate.find(query, Note.class);
    }

    @Override
    public Long countByBookId(String bookId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("book.$id").is(bookId));
        return mongoTemplate.count(query, Note.class);
    }

    @Override
    public void deleteByBookId(String bookId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("book.$id").is(bookId));
        mongoTemplate.remove(query, Note.class);
    }
}
