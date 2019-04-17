package ru.otus.igorr.books.lesson12.repository.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson12.domain.book.Book;

import java.util.List;
import java.util.Optional;

@Repository
//public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
public interface BookRepository extends JpaRepository<Book, Long> {

    @Override
    Optional<Book> findById(Long aLong);

    @Override
    <S extends Book> S save(S s);

    @Override
    <S extends Book> S saveAndFlush(S s);

    @Override
    void flush();

    @Override
    void delete(Book book);

    @Override
    List<Book> findAll();

    @Override
    Page<Book> findAll(Pageable pageable);

    @Query("select b from Book b where b.title = :title")
    Book findByTitle(@Param("title") String title);

    @Query(value = "select b.* from book b join book_author br on b.id = br.book_id where br.author_id = :id",
            nativeQuery = true)
    List<Book> findByAuthorNative(@Param("id") long id);


}


