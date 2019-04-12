package ru.otus.igorr.books.lesson10.repository.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson10.domain.book.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

    @Override
    Optional<Book> findById(Long aLong);

    @Override
    <S extends Book> S save(S s);

    @Override
    void delete(Book book);

    @Override
    List<Book> findAll();

    @Override
    Page<Book> findAll(Pageable pageable);
}
