package ru.otus.igorr.books.lesson23.repository.book;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson23.domain.book.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note, String>, NoteRepositoryCustom {

}