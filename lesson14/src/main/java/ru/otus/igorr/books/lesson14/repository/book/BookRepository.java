package ru.otus.igorr.books.lesson14.repository.book;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson14.domain.book.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String>, BookRepositoryCustom {
}


