package ru.otus.igorr.books.lesson22.repository.book;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson22.domain.book.Book;

@Repository
public interface BookReactiveRepository extends ReactiveMongoRepository<Book, String> {
}
