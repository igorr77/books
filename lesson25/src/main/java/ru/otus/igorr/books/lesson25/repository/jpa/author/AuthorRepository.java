package ru.otus.igorr.books.lesson25.repository.jpa.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson25.domain.jpa.author.Author;
import ru.otus.igorr.books.lesson25.domain.jpa.book.Book;

import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select a from Author a where a.books = :book")
    Set<Author> findByBook(@Param("book") Book book);
}
