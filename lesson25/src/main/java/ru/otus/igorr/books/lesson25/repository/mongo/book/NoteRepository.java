package ru.otus.igorr.books.lesson25.repository.mongo.book;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson25.domain.mongo.book.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note, String>, NoteRepositoryCustom {

}
