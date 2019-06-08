package ru.otus.igorr.books.lesson18.repository.book;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson18.domain.book.Note;

@Repository
public interface NoteReactiveRepository extends ReactiveMongoRepository<Note, String> {
}
