package ru.otus.igorr.books.lesson10.repository.book;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson10.domain.book.Book;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

}
